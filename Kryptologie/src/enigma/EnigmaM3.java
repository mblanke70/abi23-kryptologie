package enigma;

import java.util.HashMap;

public class EnigmaM3 {

	private static final Rotor[] rotoren = {
		new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 18),	// Rotor 1
		new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE",  6),	// Rotor 2
		new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 23),	// Rotor 3
		new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 11),	// Rotor 4
		new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK",  0)		// Rotor 5
	};
	
	private static final Rotor[] reflektoren = {
		new Rotor("AEBJCMDZFLGYHXIVKWNROQPUST", 0),		// Reflektor A
		new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT", 0),		// Reflektor B
		new Rotor("FVPJIAOYEDRZXWGCTKUQSBNMHL", 0)		// Reflektor C
	};
	
	private Rotor reflektor;
	private Rotor[] rotorgruppe;
	private HashMap<Character, Character> steckerbrett;	
	
	/**
	 * Erzeugt eine neue Enimga vom Typ M3 (Wehrmacht)
	 * 
	 * @param walzenlage Die Walzenlage codiert als String bestehend aus 4 Zeichen. Bsp.: "B142" 
	 * @param ringstellungen Die Ringstellungen der 3 Rotoren codiert als String bestehend aus 3 Buchstaben. Bsp.: "BUL"
	 * @param stecker Die Steckerbrett-Verbindungen codiert als String bestehend aus 2n Buchstaben f√ºr n Stecker. Bsp.: "AVBZ"
	 */
	public EnigmaM3(String walzenlage, String ringstellungen, String stecker)
	{
		rotorgruppe = new Rotor[3];

		// Reflektor setzen
		reflektor = reflektoren[walzenlage.charAt(0)-65];

		// Rotoren setzen
		for(int i=0; i<3; i++)
			rotorgruppe[i] = rotoren[walzenlage.charAt(i+1)-49];

		// Ringstellungen setzen
		for(int i=0; i<3; i++)
			rotorgruppe[i].setRingstellung(ringstellungen.charAt(i)-65);
		
		// Steckerbrett-Verbindungen setzen
		steckerbrett = new HashMap<Character, Character>();
		for(int i=0; i<stecker.length(); i+=2)
		{
			steckerbrett.put(stecker.charAt(i)  , stecker.charAt(i+1));
			steckerbrett.put(stecker.charAt(i+1), stecker.charAt(i)  );
		}
	}

	/**
	 * Schaltet die Engima einen Schritt weiter.
	 */
	public void step()
	{
		rotorgruppe[2].step();
		if(rotorgruppe[2].getPos()==rotorgruppe[2].get‹bertragPos()
			|| rotorgruppe[1].getPos()+1==rotorgruppe[1].get‹bertragPos())	// Sonderfall: 'double step', hat mechanische Ursachen
		{
			rotorgruppe[1].step();		
			if(rotorgruppe[1].getPos()==rotorgruppe[1].get‹bertragPos())
				rotorgruppe[0].step();
		}
		
		//System.out.println(getPos());
	}
	
	public String getPos()
	{
		String s = "";
		
		s += (char) (65 + rotorgruppe[0].getPos());
		s += (char) (65 + rotorgruppe[1].getPos());
		s += (char) (65 + rotorgruppe[2].getPos());
		
		return s;
	}
	
	/**
	 * Liefert den Code f¸r das Zeichen c
	 * @param c Das Klartext-Zeichen
	 * @return Das Geheimtext-Zeichen
	 */
	public char encode(char c)
	{
		step();

		if(steckerbrett.containsKey(c))
			c = steckerbrett.get(c);
		
		c = rotorgruppe[2].encrypt(c,0);
		c = rotorgruppe[1].encrypt(c,0);
		c = rotorgruppe[0].encrypt(c,0);
		c = reflektor.encrypt(c, 0);
		c = rotorgruppe[0].encrypt(c,1);
		c = rotorgruppe[1].encrypt(c,1);
		c = rotorgruppe[2].encrypt(c,1);
		
		if(steckerbrett.containsKey(c))
			c = steckerbrett.get(c);
		
		return c;
	}
	
	/**
	 * Codiert eine Zeichenkette ausgehend von einer bestimmten Grundstellung der Engima.
	 * 
	 * @param grundstellung Die Anfangsstellung der 3 Rotoren codiert als String bestehend aus 3 Buchstaben. Bsp.: "WXC".
	 * @param s Der Klartext.
	 * @return Der Geheimtext.
	 */
	public String encodeString(String grundstellung, String s)
	{
		String geheim ="";

		for(int i=0; i<3; i++)
			rotorgruppe[i].setPos(grundstellung.charAt(i)-65);
			
		for(char c : s.toCharArray())
			geheim += encode(c);

		return geheim;
	}


	public static void main(String[] args) 
	{
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
		
		EnigmaM3 m3 = new EnigmaM3("B245", "BUL", "AVBSCGDLFUHZINKMOWRX");
		
		System.out.println(m3.encodeString("WXC", "KCH"));
		System.out.println(m3.encodeString(m3.encodeString("WXC", "KCH"), teil1));
		System.out.println(m3.encodeString("CRS", "YPJ"));
		System.out.println(m3.encodeString("LSD", "SFBWD"));
		
	}
}
