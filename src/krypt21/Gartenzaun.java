package krypt21;

public class Gartenzaun {

	public static String encrypt(String plain)
	{
		int n = plain.length();
		String cipher = "";
		
		for(int i=0; i<n; i+=2)	{ cipher += plain.charAt(i); }
		for(int i=1; i<n; i+=2)	{ cipher += plain.charAt(i); }
		
		return cipher;
	}
	
	public static String encrypt2(String plain)
	{
		int n = plain.length();
		String head = "";
		String tail = "";
		
		for(int i=0; i<(n*2)/2; i+=2)
		{ 
			head += plain.charAt(i);
			tail += plain.charAt(i+1);
		}
		if(n%2==1) plain += plain.charAt(n-1);
		
		return head + tail;
	}
	
	public static String decrypt(String cipher)
	{
		int n = cipher.length();
		int m = n/2;
		String plain = "";
		
		for(int i=0; i<m-1; i++)	
		{ 
			plain += cipher.charAt(i); 
			plain += cipher.charAt(m+1+i); 
		}
		if(n%2==1) plain += cipher.charAt(m);
		
		return plain;
	}

	public static void main(String[] args) 
	{
		String plain = "LIEBERTUGENDHAFTALSJUGENDHAF";
		System.out.println(plain.length());
		String cipher = encrypt(plain);
		System.out.println(cipher);
		System.out.println(decrypt(cipher));
	}
}
