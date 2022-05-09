package krypt2019;

public class Playfair {
	
	public static String encrypt(String plain, String key) 
	{
		String cipher = "";
		
		// bei ungerader Textl‰nge ein X erg‰nzen
		if(plain.length()%2 == 1) {
			plain += 'X';
		}
		
		System.out.println(plain);
		
		// Playfair-Quadrat erzeugen
		char[] matrix = new char[25];
		
		// Buchstaben-Maske erzeugen
		boolean[] mask = new boolean[26];
		
		int j=0;
		
		// Schl√ºsselwortbuchstaben eintragen
		for(int i=0; i<key.length(); i++) {
			char c = key.charAt(i);
			if(!mask[c-65]) {
				matrix[j++] = c;
				mask[c-65] = true;
			}
		}
		
		// TB VR CF IG ZL VC XM HQ EV BL IG RW VT
		
		// Restliche Buchstaben eintragen
		for(int i='A'; i<='Z'; i++) {
			if(!mask[i-65] && i!='J') {
				matrix[j++] = (char) i;
			}
		}
		
		// Matrix ausgeben
		for(int k=0; k<25; k++) {
			System.out.print(matrix[k] + " ");
			if(k%5==4) System.out.println();
		}
				
		// Klartext durchlaufen
		for(int k=0; k<plain.length(); k+=2)
		{
			// Buchstabenpaar entnehmen
			char b1 = plain.charAt(k);
			char b2 = plain.charAt(k+1);

			int x=0, y=0;
			
			// Buchstaben in Matrix suchen
			for(int i=0; i<25; i++) {
				if(matrix[i] == b1) x=i;
				if(matrix[i] == b2) y=i;
			}
						
			// Zeile/Spalte bestimmen
			int x_row = x/5;
			int x_col = x%5;
			int y_row = y/5;
			int y_col = y%5;
			
			// Buchstaben in gleicher Zeile
			if(x_row == y_row) {
				cipher += matrix[(x+1)%25];
				cipher += matrix[(y+1)%25];
			}
			// Buchstaben in gleicher Spalte
			else if(x_col == y_col) {
				cipher += matrix[(x+5)%25];
				cipher += matrix[(y+5)%25];
			}
			// sonst
			else {
				cipher += matrix[x_row*5+y_col];
				cipher += matrix[y_row*5+x_col];
			}	
		}
		
		return cipher;
	}

	public static void main(String[] args) 
	{
		String plain = "PERANHALTERDURCHDIEGALAXIS"; 
		String cipher = encrypt(plain, "MARVIN");
		
		System.out.println(cipher);		
	}
}