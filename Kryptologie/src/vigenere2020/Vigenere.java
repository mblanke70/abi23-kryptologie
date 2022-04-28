package vigenere2020;

public class Vigenere {
	
	public static String encrypt(String plain, String keyword) {
		String cipher = "";
		for(int i=0; i<plain.length(); i++) {
			int key = keyword.charAt(i % keyword.length()) - 65; 
			cipher += Caesar.encrypt(plain.charAt(i)+"", key); 
		}
		return cipher; 
	}
	
	public static String decrypt(String cipher, String keyword) { 
		String plain = "";
		for(int i=0; i<cipher.length(); i++) { 
			int key = keyword.charAt(i % keyword.length()) - 65;
			plain += Caesar.decrypt(cipher.charAt(i)+"", key); 
		} 
		return plain;
	}	
	
}
