package krypt21;

public class Skytale {

	public static String encrypt(String plain, int key)
	{
		String cipher = "";
		
		
		
		return cipher;
	}
	
	public static String decrypt(String cipher, int key)
	{
		String[] plain = new String[key];
		for(int i=0; i<key; i++) { plain[i] = ""; }
		
		for(int i=0; i<cipher.length(); i++)
		{
			plain[i%key] += cipher.charAt(i);
		}
		
		StringBuffer sb = new StringBuffer();
	    for(int i=0; i<plain.length; i++) {
	    	sb.append(plain[i]);
	    }

		return sb.toString();
	}
	
	public static void main(String[] args) 
	{
		String plain1 = "TARNUNGAUFGEFLOGENSTOPBINENTDECKTSTOPFLUCHTNACHDAENEMARK";
		String cipher1 = encrypt(plain1, 6);
		System.out.println(cipher1);
		
		String cipher2 = "KUITKSOHTZEPMETUTIMUAMBESTGALTEMALEDMISLN";
		System.out.println(decrypt(cipher2, 6));
	}

}
