package krypt21;

public class Mono 
{
	public static String encrypt(String plain, String key)
	{
		String cipher = "";
		String cta = "";
		
		for(int i=0; i<key.length(); i++)
		{
			char c = key.charAt(i);
			if(cta.indexOf(c) < 0) { cta += c; }
		}
		
		System.out.println(cta);
		
		// letzten Buchstaben bestimmen
		
		// 26 - L�nge des "jetzt-schon-Geheimtextalphbets" mal sind noch
		// Buchstaben anzuh�ngen (=> Schleife)
		
			// innerhalb der Schleife alphabetisch zeichenweise vorr�cken
			// und an Geheimtextalphabet anh�ngen
		
			

	
		return cipher;
	}
	
	public static void main(String[] argv)
	{
		String key   = "NOFRETETE";
		String plain = "DIESCHWALBEHATUNTERFOLTERALLESVERRATEN";
		
		System.out.println(plain);
		encrypt(plain, key);
	}
}
