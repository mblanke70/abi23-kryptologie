package rsa2020;

import java.math.BigInteger;
import java.util.HashMap;

public class RSA {

	private HashMap<String, BigInteger[]> rsa;
	
	private BigInteger N = new BigInteger("8733086241394115882430494415832850074607377241774808086653");
	private BigInteger d = new BigInteger("1286424492478423"); // öffentlich
	private BigInteger e = new BigInteger("3317752064969774574409205709073793118278273461585848585147"); // geheim
	
	public RSA() 
	{
		rsa = new HashMap<String, BigInteger[]>();
	
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
		rsa.put("Blanke", new BigInteger[] {
				new BigInteger("1286424492478423"), 
				new BigInteger("8733086241394115882430494415832850074607377241774808086653")
		});
	}
	
	public void send(String message, String recipient)
	{
		System.out.println("##### Sende an " + recipient + " #####");

		BigInteger plain  = encode(message);
		BigInteger cipher = plain.modPow(rsa.get(recipient)[0], rsa.get(recipient)[1]);
		
		Integer hash = plain.hashCode();
		BigInteger big_hash = new BigInteger(hash.toString());
		BigInteger signatur = big_hash.modPow(e, N).add(N).mod(N);

		System.out.println("Signatur: " + signatur);
		System.out.println("An " + recipient + ": " + cipher);	
	}
	
	public void receive(BigInteger cipher, String sender, BigInteger signatur)
	{
		System.out.println("##### Empfange von " + sender + " #####");
		
		BigInteger plain = cipher.modPow(e, N);
		System.out.println("Nachricht: " + decode(plain));
		System.out.println("Hash: "    + plain.hashCode());
		
		BigInteger hash = signatur.modPow(rsa.get(sender)[0], rsa.get(sender)[1]);
		System.out.println("Signatur: " + hash);
	}
	
	public static void main(String[] args) 
	{
		RSA rsa = new RSA();
		
		rsa.send("BIGBEN", "Glenn");
		rsa.receive(
				new BigInteger("3533420086948926210794234720369364209780163826011025243781"),
				"Glenn", 
				new BigInteger("4442024183869767264543")
		);
		rsa.receive(
				new BigInteger("6323818442730490989787842957861256788389836179346791076288"),
				"Max",
				new BigInteger("47968998006090")
		);
	}
	
	public BigInteger encode(String plain) {
		String s = "";
		for(int i=0; i<plain.length(); i++) {
			int  c = plain.charAt(i) - 64;
			s += (c<10) ? "0" + c : "" + c; 
		}
    
		return new BigInteger(s);
	}
  
	public String decode(BigInteger plain_encoded) {
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
}
