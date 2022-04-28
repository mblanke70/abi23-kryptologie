package mono23;

public class Vigenere {

	public static char shift(char c, int k) {
		return (char) ((( c - 65 + k ) % 26 ) + 65 );
	}
	
	public static String caesar(String arg, int key) {
		String res = "";
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			res += shift(c, key);
		}
		return res;
	}
	
	public static String vigenere(String arg, String keyword) {
		String res = "";
	
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			res += shift(c, keyword.charAt( i % keyword.length() ) - 65 );
			// keyword = BRUTUS

			// c = arg.charAt(i);
			// res += shift(c, 'B'-65);
			
			// c = arg.charAt(i);
			// res += shift(c, 'R'-65); 

			// c = arg.charAt(i);
			// res += shift(c, 'U'-65); 
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String plain = "LIEBERALT";

		String cipher1 = caesar(plain, 3);
		System.out.println( cipher1 );
		
		System.out.println( caesar( cipher1, 23 ) );
		
		String cipher2 = vigenere(plain, "CODE");
		System.out.println( cipher2 );		
	}

}
