package enigma;

import java.util.HashMap;

public class Enigma
{
	private static final Rotor[] rotoren = {
		new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 18),	// Rotor 1
		new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE",  6),	// Rotor 2
		new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 23),	// Rotor 3
		new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 11),	// Rotor 4
		new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK",  0)		// Rotor 5
	};
	
	private static final Rotor[] reflektoren = {
		new Rotor("AEBJCMDZFLGYHXIVKWNROQPUST",  0),	// Reflektor A
		new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT",  0),	// Reflektor B
		new Rotor("FVPJIAOYEDRZXWGCTKUQSBNMHL",  0)		// Reflektor C
	};
	
	private Rotor   reflektor;
	private Rotor[] rotorgruppe;
	private HashMap<Character, Character> steckerbrett;
	
	public Enigma(String config, String ringstellung, String stecker)
	{
		rotorgruppe = new Rotor[3];
		
		reflektor = reflektoren[config.charAt(0)-65];
		
		for(int i=0; i<3; i++)
			rotorgruppe[i] = rotoren[config.charAt(i+1)-49];
		
		for(int i=0; i<3; i++)
			rotorgruppe[i].setRingstellung(ringstellung.charAt(i)-65);
		
		steckerbrett = new HashMap<Character, Character>();
		for(int i=0; i<stecker.length(); i+=2)
		{
			steckerbrett.put( stecker.charAt(i), stecker.charAt(i+1) );
			steckerbrett.put( stecker.charAt(i+1), stecker.charAt(i) );
		}
	}
			
	private char encrypt(char c)
	{
		step();
		
		if(steckerbrett.containsKey(c))
			c = steckerbrett.get(c);
											
		c = rotorgruppe[2].encrypt(c, 0);
		c = rotorgruppe[1].encrypt(c, 0);
		c = rotorgruppe[0].encrypt(c, 0);
		c = reflektor.     encrypt(c, 0); 	// == refl.encrypt(c,1)
		c = rotorgruppe[0].encrypt(c, 1);
		c = rotorgruppe[1].encrypt(c, 1);
		c = rotorgruppe[2].encrypt(c, 1);
		
		if(steckerbrett.containsKey(c))
			c = steckerbrett.get(c);		
		
		return c;
	}
	
	public String encrypt(String text, String grundstellung)
	{
		String c = "";
		
		for(int i=0; i<3; i++)
			rotorgruppe[i].setPos(grundstellung.charAt(i)-65);
		
		for(char l : text.toCharArray())
			c += encrypt(l);
		
		return c;
	}
	
	public void step()
	{
		rotorgruppe[2].step();
		if(rotorgruppe[2].getPos() == rotorgruppe[2].getUebertragPos())
			// || rotorgruppe[1].getPos()+1==rotorgruppe[1].get�bertragPos())	// Sonderfall: 'double step', hat mechanische Ursachen
		{
			rotorgruppe[1].step();
			if(rotorgruppe[1].getPos() == rotorgruppe[1].getUebertragPos())
			{
				rotorgruppe[0].step();
			}
		}
	}
	
	private String getPosString()
	{
		String s = "";
		
		s += (char) (65 + rotorgruppe[0].getPos());
		s += (char) (65 + rotorgruppe[1].getPos());
		s += (char) (65 + rotorgruppe[2].getPos());
		
		return s;
	}

	public static void main(String[] args) 
	{
		Enigma enigma = new Enigma("B245", "BUL", "AVBSCGDLFUHZINKMOWRX");
		
		String teil1 = 
			      "EDPUD NRGYS ZRCXN" +
			"UYTPO MRMBO FKTBZ REZKM" +
			"LXLVE FGUEY SIOZV EQMIK" +
			"UBPMM YLKLT TDEIS MDICA" +
			"GYKUA CTCDO MOHWX MUUIA" +
			"UBSTS LRNBZ SZWNR FXWFY" +
			"SSXJZ VIJHI DISHP RKLKA" +
			"YUPAD TXQSP INQMA TLPIF" +
			"SVKDA SCTAC DPBOP VHJK";
		
		String teil2 = 
			      "SFBWD NJUSE GQOBH" +
			"KRTAR EEZMW KPPRB XOHDR" +
			"OEQGB BGTQV PGVKB VVGBI" +
			"MHUSZ YDAJQ IROAX SSSNR" +
			"EHYGG RPISE ZBOVM QIEMM" +
			"ZCYSG QDGRE RVBIL EKXYQ" +
			"IRGIR QNRDN VRXCY YTNJR";

		teil1 = teil1.replaceAll(" ", "");
		teil2 = teil2.replaceAll(" ", "");

		System.out.println(enigma.encrypt("KCH", "WXC"));
		System.out.println(enigma.encrypt(teil1, "BLA"));
		
		System.out.println(enigma.encrypt("YPJ", "CRS"));
		System.out.println(enigma.encrypt(teil2, "LSD"));
	}
}
