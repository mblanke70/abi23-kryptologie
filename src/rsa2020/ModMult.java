package rsa2020;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Arrays;

public class ModMult{
  
	public static BigInteger encode(String plain) {
		String s = "";
		for(int i=0; i<plain.length(); i++) {
			int  c = plain.charAt(i) - 64;
			s += (c<10) ? "0" + c : "" + c; 
		}
    
		return new BigInteger(s);
	}
  
	public static String decode(BigInteger plain_encoded) {
		String p = "";
		String e = plain_encoded.toString();
		
		if(e.length()%2 == 1) {
			e = "0" + e;
		}
		
		for(int i=0; i<e.length(); i+=2) {
			String c = e.substring(i,i+2);
			p += (char) (Integer.parseInt(c) + 64);
		}
    
		return p;
	}
  
	// COMMENT
	public static int ggt(int a, int b) {
		if (b==0) {	return a; }	
  		return ggt(b, a%b);
  	}
	
  	public static void main(String[] args) {
  		
  		BigInteger p = new BigInteger("93450983094850938450983409611");
		BigInteger q = new BigInteger("93450983094850938450983409623");
		
		BigInteger N = p.multiply(q);
		System.out.println(N);

		BigInteger plain = encode("BIGBEN");
		System.out.println(plain);

		BigInteger M = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		System.out.println(M);
		
		BigInteger d = new BigInteger("1286424492478423");
		System.out.println("Öffentlicher Schlüssel" + d);
		System.out.println(M.gcd(d));
		
		BigInteger e = modInv(M,d);
		System.out.println("Geheimer Schlüssel" + e);
				
		// Signatur
		Integer hash = plain.hashCode();
		System.out.println("HashCode: " + hash);
		BigInteger big_hash = new BigInteger(hash.toString());
		BigInteger signatur = big_hash.modPow(e, N);
		System.out.println("Signatur: " + signatur);
		
		HashMap<String, BigInteger[]> rsa = new HashMap<String, BigInteger[]>();
		
		rsa.put("Jonathan", new BigInteger[] {
				new BigInteger("17"),
				new BigInteger("30157433021959")
		});
		rsa.put("Laurenz", new BigInteger[] {
				new BigInteger("9007"),
				new BigInteger("114381625757888867669235779976146612010218296721242362562561842935706935245733897830597123563958705058989075147599290026879543541")
		});
		rsa.put("Simon", new BigInteger[] {
				new BigInteger("50423"),
				new BigInteger("1000000020000000000")
		});
		rsa.put("Sara", new BigInteger[] {
				new BigInteger("68927"),
				new BigInteger("868945637754051317403289")
		});
		rsa.put("Glenn", new BigInteger[] {
				new BigInteger("83791"),
				new BigInteger("9283753392619366110887")
		});
		rsa.put("Richard", new BigInteger[] {
				new BigInteger("5"),
				new BigInteger("8378222961420")
		});
		rsa.put("Max", new BigInteger[] {
				new BigInteger("5651"),
				new BigInteger("99989009698933")
		});	
		rsa.put("Anneke", new BigInteger[] {
				new BigInteger("8494996873"),
				new BigInteger("37458645173")
		});
		rsa.put("Henry", new BigInteger[] {
				new BigInteger("559438804705466189901215275073997299619305858712037"),
				new BigInteger("11447170505525045434474940987261157718424296282599167")
		});
		rsa.put("Finn", new BigInteger[] {
				new BigInteger("11"), 
				new BigInteger("101485451")
		});
		rsa.put("Leo", new BigInteger[] {
				new BigInteger("1213"), 
				new BigInteger("96843939")
		});
		rsa.put("Jonah", new BigInteger[] {
				new BigInteger("55495023617828067013451"), 
				new BigInteger("918607243284077785519223")
		});
		rsa.put("Matthis", new BigInteger[] {
				new BigInteger("21664990187285902021"), 
				new BigInteger("17481359031306636901")
		});
		
		// Anneke
		System.out.println("An Glenn: "  + 
				plain.modPow(rsa.get("Glenn")[0], rsa.get("Glenn")[1]));
		System.out.println("An Jonthan: "  + 
				plain.modPow(rsa.get("Jonathan")[0], rsa.get("Jonathan")[1]));
		System.out.println("An Simon: "  + 
				plain.modPow(rsa.get("Simon")[0], rsa.get("Simon")[1]));
		System.out.println("An Sara: "  + 
				plain.modPow(rsa.get("Sara")[0], rsa.get("Sara")[1]));
		System.out.println("An Max: "  + 
				plain.modPow(rsa.get("Max")[0], rsa.get("Max")[1]));
		System.out.println("An Laurenz: "  + 
				plain.modPow(rsa.get("Laurenz")[0], rsa.get("Laurenz")[1]));
		System.out.println("An Richard: "  + 
				plain.modPow(rsa.get("Richard")[0], rsa.get("Richard")[1]));
		
		System.out.println("An Anneke: "  + 
				plain.modPow(rsa.get("Anneke")[0], rsa.get("Anneke")[1]) + " " + signatur);
		System.out.println("An Henry: "   + 
				plain.modPow(rsa.get("Henry")[0] , rsa.get("Henry")[1])  + " " + signatur);
		System.out.println("An Finn: "    + 
				plain.modPow(rsa.get("Finn")[0]  , rsa.get("Finn")[1])  + " " + signatur);
		System.out.println("An Leo: "     + 
				plain.modPow(rsa.get("Leo")[0]   , rsa.get("Leo")[1])  + " " + signatur);
		System.out.println("An Jonah: "   + 
				plain.modPow(rsa.get("Jonah")[0] , rsa.get("Jonah")[1]) + " " + signatur);
		System.out.println("An Matthis: " + 
				plain.modPow(rsa.get("Matthis")[0], rsa.get("Matthis")[1]) + " " + signatur);
		
		// Entschlüsseln einer Nachricht an mich
		BigInteger geheim_leo = new BigInteger("635737380816420448065473806947924636334948226929108422398");
		BigInteger klar_leo = geheim_leo.modPow(e, N);
		System.out.println(decode(klar_leo));
		System.out.println("Hash: " + klar_leo.hashCode());
		
		BigInteger signatur_sara = new BigInteger("151528943967322218787395");
		BigInteger hash_sara = signatur_sara.modPow(new BigInteger("68927"), new BigInteger("868945637754051317403289"));
		System.out.println(hash_sara);
		
		BigInteger signatur_glenn = new BigInteger("4442024183869767264543");
		BigInteger hash_glenn = signatur_glenn.modPow(new BigInteger("83791"), new BigInteger("9283753392619366110887"));
		System.out.println(hash_glenn);
		
		/*
		BigInteger signatur = plain.modPow(e, N);
		System.out.println(signatur);
		
		BigInteger decrypted = signatur.modPow(d, N);
		System.out.println(decode(decrypted));
		*/
/*			
		// Wikipedia: RSA-129
		BigInteger p = new BigInteger("3490529510847650949147849619903898133417764638493387843990820577");
		BigInteger q = new BigInteger("32769132993266709549961988190834461413177642967992942539798288533");

		// Berechne (p-1)*(q-1)
		System.out.println(M);
   
		// EEA anwenden
		BigInteger e = d.modInverse(M);
		System.out.println(e);
		System.out.println(eea(M,d)[1].add(M));
		
		// Entschlüsseln des Geheimtextes c (mit Hilfe von N und e)
		BigInteger plain = c.modPow(e,N);
		System.out.println(plain);
		
		System.out.println(decode(plain));
*/
  	}
  	
  	public static BigInteger modInv(BigInteger a, BigInteger b)
  	{
  		return eea(a,b)[1].add(a).mod(a);
  	}
  	
  	public static BigInteger[] eea(BigInteger a, BigInteger b) 
	{	
		if( b.equals(BigInteger.ZERO) ) {
			return new BigInteger[] {BigInteger.ONE, BigInteger.ZERO};
		} 
			
		BigInteger[] result = eea(b, a.mod(b));
		BigInteger x_alt = result[0];
		BigInteger y_alt = result[1];
		
		BigInteger x = y_alt;
		BigInteger y = x_alt.subtract( y_alt.multiply( a.divide(b) ) );
		
		return new BigInteger[] {x, y};
	}
}





















/*

    
    
   
    
    
   

    
    
    
   
   
*/
