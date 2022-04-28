package krypt21;

public class Caesar 
{
	public static String encrypt(String plain)
	{
		String cipher = "";
		
		for(int i=0; i<plain.length(); i++)
		{
			cipher += (char) ( ( (plain.charAt(i)-65+3) %26 ) +65 );
		}
		
		return cipher;
	}
	
	public static String decrypt(String cipher)
	{
		String plain = "";
		
		return plain;
	}
	
	public static void main(String[] args) 
	{
		String plain = "DIESPINNENDIEGALLIER";
		
		String cipher = encrypt(plain);
		
		System.out.println(cipher);
		System.out.println(decrypt(cipher));
	}
}
