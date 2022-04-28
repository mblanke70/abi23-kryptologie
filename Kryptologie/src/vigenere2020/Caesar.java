package vigenere2020;

import java.util.TreeMap;
import java.util.Map;

public class Caesar {
	
	public static final double[] DEUTSCH = {
		6.51, 1.89, 3.06, 5.08, 17.41, 1.66, 3.01, 
		4.76, 7.55, 0.27, 1.21,  3.44, 2.53, 9.78, 
		2.51, 0.79, 0.02, 7.00,  7.89, 6.15, 4.35, 
		0.67, 1.89, 0.03, 0.04,  1.13
	};
  
	// COMMENT
	public static int[] calcAbsFreqs(String cipher) {
		cipher = cipher.toUpperCase();
    	int[] absFreqs = new int[26];
    	for (int i=0; i<cipher.length(); i++) {
    		absFreqs[(cipher.charAt(i)-65)]++;
		}
    	return absFreqs;
	}
	
	// COMMENT
	public static double[] calcRelFreqs(String cipher) {
		cipher = cipher.toUpperCase();
    	int[] absFreqs = calcAbsFreqs(cipher);
    	double[] relFreqs = new double[26];
    	for (int i=0; i<absFreqs.length; i++) {
    		relFreqs[i] = (double) absFreqs[i] / cipher.length() * 100;
    	}
		return relFreqs;
	}
	
	public static String encrypt(String plain, int key) {
		plain=plain.toUpperCase();
		String cipher = "";
    	for(int i=0; i<plain.length(); i++) {
    		cipher += (char)( ( (plain.charAt(i)-65+key) % 26) + 65 );
    	}
    	return cipher;
  	}
    
    public static String decrypt(String cipher, int key) {
      cipher = cipher.toUpperCase();
      String plain = "";
      for(int i=0; i<cipher.length(); i++) {
    	  plain += (char)( ( (cipher.charAt(i)-65+(26-key) ) % 26) + 65 );
      }
      return plain;
    }
    
    public static String calcCaesarKey(String cipher) {
    	String sortedKeys = "";
    	
		// Für jeden Teilstring eine Häufigkeitsanalyse durchführen und daraus jeweils die Caesar-Verschiebung (=Schlüsselbuchstabe) bestimmen
		double[] relFreqs = calcRelFreqs(cipher);

		Map<Double, Integer> ranking = new TreeMap<Double, Integer>();

		for(int key=0; key<26; key++) {
			double sum = 0;
			for(int i=0; i<26; i++) {
				sum += Math.abs(DEUTSCH[i] - relFreqs[(key+i)%26]);
			}
			ranking.put(sum, key);
		}
		
		//System.out.println(ranking);
		
		for (Integer value : ranking.values()) {
		    sortedKeys += (char) (value+65);
		}
		System.out.println(sortedKeys);
		
		return sortedKeys;
	}
    
    public static void main(String[] args) {
    	String cipher = "APENCAURYACDADHPPPTPEOEPTFPPPMCOCYODWPCOYDSWYEDTEZWDPPQTONHTAYEPFZYOEOMCOYYRYPMCWNYSOSPYCPSPKPPZGLDODFSYPW";
    	calcCaesarKey(cipher);
    }
}
