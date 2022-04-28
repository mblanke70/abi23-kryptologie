package mono23;

public class Caesar {
	
	public static String stage2 = "MHILYLZAZBHLXBPZXBLMVYABUHLHWWPBZJSHBKPBZJHLJBZKPJABTHYJHUBTLZAULBAYVU";
	
	public static String encrypt(String plain, int key) {
		String cipher="";
		for(int i=0; i<plain.length(); i++) {
			char c = plain.charAt(i);
			cipher += (char) (((c-65+key)%26)+65);
		}
		return cipher;
	}
	
	public static String decrypt(String cipher, int key) {
		String plain="";
		for(int i=0; i<cipher.length(); i++) {
			char c = cipher.charAt(i);
			plain += (char) (((c-65+(26-key))%26)+65);
		}
		return plain;
	}
	
	public static void main(String[] args) {
		String cipher = encrypt("VENIVIDIVICI",3);
		System.out.println(cipher);
		
		String plain = decrypt(encrypt("VENIVIDIVICI",3),3);
		System.out.println(plain);
		
		System.out.println();
		
		for(int i=0; i<26; i++) {
			System.out.println(decrypt(stage2,i));
		}
		
		// FABER EST SUAE QUIS QUE FORTUNAE APPIUS CLAUDIUS CAECUS DICTUM ARCANUM EST NEUTRON
	}
	
	public static final double[] DEUTSCH = {
		6.51, 1.89, 3.06, 5.08, 17.41, 1.66, 3.01, 
		4.76, 7.55, 0.27, 1.21,  3.44, 2.53, 9.78, 
		2.51, 0.79, 0.02, 7.00,  7.89, 6.15, 4.35, 
		0.67, 1.89, 0.03, 0.04,  1.13
	};
		
	public static char[] genarateKeyRanking(String cipher) {
		char[] ranking = new char[26];

		
		return ranking;
	}
}
