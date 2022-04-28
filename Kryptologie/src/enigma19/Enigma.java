package enigma19;

public class Enigma 
{	
	private static final Rotor[] rotoren = {
		new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 16),	// Rotor 1
		new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE",  4),	// Rotor 2
		new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 21),	// Rotor 3
		new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB",  9),	// Rotor 4
		new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 25)		// Rotor 5
	};
	
	private static final Rotor[] reflektoren = {
		new Rotor("AEBJCMDZFLGYHXIVKWNROQPUST", -1),	// Reflektor A
		new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT", -1),	// Reflektor B
		new Rotor("FVPJIAOYEDRZXWGCTKUQSBNMHL", -1)		// Reflektor C
	};
	
	private Rotor[] rotorgruppe;
	
	public Enigma(String config) {
		rotorgruppe = new Rotor[4];
		
		rotorgruppe[0] = reflektoren[config.charAt(0) - 65];	// refl
		rotorgruppe[1] = rotoren[config.charAt(1) - 49];		// left
		rotorgruppe[2] = rotoren[config.charAt(2) - 49]; 		// mid
		rotorgruppe[3] = rotoren[config.charAt(3) - 49];		// right
	}
		
	public void step()	// ADQ - AER - AFS
	{
		if(rotorgruppe[2].getPos() == rotorgruppe[2].getCarryPos()) {
			rotorgruppe[2].step();
			rotorgruppe[1].step();
		}
		
		if(rotorgruppe[3].getPos() == rotorgruppe[3].getCarryPos()) {
			rotorgruppe[2].step();
		}
		
		rotorgruppe[3].step();
	}
	
	public String toString()
	{
		String c = "";
		
		c += (char) (rotorgruppe[1].getPos() + 65); 
		c += (char) (rotorgruppe[2].getPos() + 65); 
		c += (char) (rotorgruppe[3].getPos() + 65); 
		
		return c;
	}
	
	public char encrypt(char c)
	{
		step();

		System.out.println(this);

		c = rotorgruppe[3].encrypt(c, 0);
		c = rotorgruppe[2].encrypt(c, 0);
		c = rotorgruppe[1].encrypt(c, 0);
		c = rotorgruppe[0].encrypt(c, 0);
		c = rotorgruppe[1].encrypt(c, 1);
		c = rotorgruppe[2].encrypt(c, 1);
		c = rotorgruppe[3].encrypt(c, 1);

		return c;
	}
	
	public String encrypt(String grundstellung, String ringstellung, String plain)
	{
		String cipher = "";
		
		for(int i=0; i<3; i++)
			rotorgruppe[i+1].setPos(grundstellung.charAt(i)-65);
		
		for(int i=0; i<3; i++)
			rotorgruppe[i+1].setRingstellung(ringstellung.charAt(i)-65);
		
		for(int i=0; i<plain.length(); i++)
			cipher += encrypt(plain.charAt(i));
		
		return cipher;
	}
	
	public static void main(String[] args) 
	{
		Enigma enigma = new Enigma("B321");
		
		String cipher = enigma.encrypt("AAA", "BBB", "AAAAAAAAAA");
		System.out.println(cipher);
	}
}