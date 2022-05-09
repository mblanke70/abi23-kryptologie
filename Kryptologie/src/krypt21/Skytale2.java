package krypt21;

public class Skytale2 
{
	public static String encrypt(String plain, int key)
	{
		String cipher = "";
		
		for(int i=0; i<key; i++)
		{
			for(int j=i; j<plain.length(); j+=key)
			{
				cipher += plain.charAt(j);
			}
		}
		
		return cipher;
	}
	
	public static String decrypt(String cipher, int key)
	{
		String plain = "";
		
		return plain;
	}
	
	// KUITKSOHTZEPMETUTIMUAMBESTGALTEMALEDMISLN
	public static void main(String[] args) 
	{
		String plain = "KOMMSTDUHEUTEMITTAGMITZUMBASKETBALLSPIELEN";
		String cipher = encrypt(plain, 7);
		
		System.out.println(cipher);
		//System.out.println(decrypt(cipher));

	}

}
