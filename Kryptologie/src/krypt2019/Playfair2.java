package krypt2019;

public class Playfair2 {
	
	public static String encrypt(String plain, String key) 
	{
		String cipher = "";
		
		// bei ungerader Textlänge ein X ergänzen
		if(plain.length()%2 == 1) { plain += 'X'; }
		
		System.out.println(plain);

		// Playfair-Quadrat erzeugen
		String matrix   = "";
		String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		
		// Schlüsselwortbuchstaben eintragen
		for(int i=0; i<key.length(); i++) 
		{
			char c = key.charAt(i);
			if(matrix.indexOf(c+"")<0) { matrix += c; }
		}
		
		// Restliche Buchstaben eintragen
		for(int i=0; i<alphabet.length(); i++) 
		{
			char c = alphabet.charAt(i);
			if(matrix.indexOf(c+"")<0) { matrix += c; }
		}
		
		//System.out.println(alphabet);
		//System.out.println(matrix);

		for(int k=0; k<plain.length(); k+=2) 
		{
			char b1 = plain.charAt(k);
			char b2 = plain.charAt(k+1);
			
			int x = matrix.indexOf(b1);
			int y = matrix.indexOf(b2);
			
			int x_row = x/5;
			int x_col = x%5;
			int y_row = y/5;
			int y_col = y%5;
						
			if(x_row == y_row)
			{
				cipher += matrix.charAt((x+1)%25);
				cipher += matrix.charAt((y+1)%25);
			} 
			else if(x_col == y_col) 
			{
				cipher += matrix.charAt((x+5)%25);
				cipher += matrix.charAt((y+5)%25);
			}
			else
			{
				cipher += matrix.charAt(x_row*5+y_col);
				cipher += matrix.charAt(y_row*5+x_col);
			}
		}
		
		return cipher;
		
		// TB VR CF IG ZL VC XM HQ EV BL IG RW VT
	}

	public static void main(String[] args) 
	{
		String plain = "PERANHALTERDURCHDIEGALAXIS"; 
		String cipher = encrypt(plain, "MARVIN");	
		System.out.println(cipher);		
	}
}