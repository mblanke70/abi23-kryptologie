package vigenere2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Kasiski {
		
	// COMMENT
	public static int calcKeywordLength(String cipher, int min, int max) {
		ArrayList<Integer> distance = new ArrayList<Integer>();				// COMMENT
		cipher = cipher.toUpperCase();
		
		for(int length=min; length<=max; length++) {   						// COMMENT
			System.out.println("Länge:" + length);
			for(int pos=0; pos<=cipher.length()-length*2; pos++) {			// COMMENT
				String pattern = cipher.substring(pos,pos+length);			// COMMENT
				for(int i=pos+length; i<=cipher.length()-length; i++) {		// COMMENT
					if(cipher.startsWith(pattern, i)){
						System.out.println("Muster: " + pattern + " | Abstand: " + (i-pos));
						if(!distance.contains(i-pos)) {
							distance.add(i-pos);  
						}
					}
				}
			}
		}
		
		//System.out.println("Gefundene Abstände: "+ distance);
		
		int ggt = distance.get(0);
		for (int i=1; i<distance.size(); i++) {			// COMMENT
			ggt = ggt(ggt,distance.get(i));
		}
		
		return ggt;
	}
	
	public static String[] splitCipher(String cipher, int keylength) {
		String[] splitCipher = new String[keylength];	// COMMENT
		
		// COMMENT
		for (int keypos=0; keypos<keylength; keypos++) {
			splitCipher[keypos] = "";
			for (int i=keypos; i<cipher.length(); i+=keylength) {
				splitCipher[keypos] += cipher.charAt(i);
			}
		}
		
		return splitCipher;
	}
	
	// COMMENT
	public static String calcKeyword(String cipher, int keylength) {
		String keyword = "";
		
		// COMMENT
		String[] splitCipher = splitCipher(cipher, keylength); 
		String[] sortedKeys  = new String[keylength];
		
		// Für jeden Teilstring eine Häufigkeitsanalyse durchführen und daraus jeweils die Caesar-Verschiebung (=Schlüsselbuchstabe) bestimmen
		for(int c=0; c<keylength; c++) {
			
			sortedKeys[c] = Caesar.calcCaesarKey(splitCipher[c]);

			// Schlüsselbuchstaben zum Schlüsselwort zusammensetzen
			keyword += (char) sortedKeys[c].charAt(0);
		}
		 
		return keyword;
	}
	
	public static void main(String[] args) {
		String cipher = readTextFromFile("src/vigenere2020/cipherL.txt");
		System.out.println("Geheimtext: " + cipher);
		System.out.println("Länge: " + cipher.length());
				
		System.out.println("================================================================");
		int keywordLength = calcKeywordLength(cipher,5,8);		// 1. Schlüsselwortlänge bestimmen
		System.out.println();
		System.out.println("Vermutete Schlüsselwortlänge: " + keywordLength);
		
		System.out.println("================================================================");
		String keyword = calcKeyword(cipher, 7);	// 2. Schlüsselwort bestimmen
		
		System.out.println("================================================================");
		System.out.println("Schlüsselwort: " + keyword);

		System.out.println("================================================================");
		String plain = Vigenere.decrypt(cipher, "FONTANE");		// 3. Geheimtext mit Schlüsselwort entschlüsseln
		System.out.println("Klartext: " + plain);
	}
	
	// COMMENT
	public static int ggt(int a, int b) {
		if (b==0) {	return a; }
		if (b>a)  { return ggt(b, a); }
		return ggt(a%b, b);
	}
			
	// Text-Datei einlesen und als String zurückgeben
	public static String readTextFromFile(String filename) {
		String text = "";
		
	    try {
	    	File file = new File(filename);
	    	Scanner scanner = new Scanner(file);
	    	while (scanner.hasNextLine()) {
	    		text += scanner.nextLine();
	    	}
	    	scanner.close();
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	    
	    return text;
	}
}
