package mono23;

import java.util.Arrays;

public class Vigenere {

	public static char shift(char c, int k) {
		return (char) ((( c - 65 + k ) % 26 ) + 65 );
	}
	
	/*
	public static String caesar(String arg, int key, boolean encrypt) {
		String res = "";
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			if(!encrypt) key = 26-key;
			res += shift(c, key);
		}
		return res;
	}
	*/
	
	public static String vigenere(String arg, String keyword, boolean encrypt) {
		String res = "";
	
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			int k = keyword.charAt( i % keyword.length() ) - 65;
			if(!encrypt) k = 26-k;;
			res += shift(c, k);
		}
		
		return res;
	}
	
	public static void main(String[] args) {

		String cipherA = 
				
				  "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZ"
				+ "USJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPA"
				+ "DWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCU"
				+ "EKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQ"
				+ "PRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEO"
				+ "OWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEO"
				+ "DSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZ"
				+ "EUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPY"
				+ "TQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVL"
				+ "EOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCV"
				+ "OSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKUL"
				+ "YJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJ"
				+ "SBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGU"
				+ "SSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHY"
				+ "LUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPA"
				+ "PAGVKVLWZKV";
		
		String cipherB = 
				
				  "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUM"
				+ "BSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJ"
				+ "BGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJU"
				+ "UQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEED"
				+ "CTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHR"
				+ "SPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOY"
				+ "CWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUC"
				+ "CESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDG"
				+ "AVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTW"
				+ "GMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTE"
				+ "JKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOF"
				+ "EKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGG"
				+ "QEUJYOTVGGBRUJYS";
		
		//System.out.println( vigenere(cipherA, "LOGISCH", false) );
		
		String[] gruppen = partition(cipherB, 5);
		System.out.println( Arrays.toString(gruppen) );
		
		for(int i=0; i<5; i++) {
			System.out.println( (i+1) + ". Buchstabe : " + Arrays.toString( absFreqs(gruppen[i])) );
		}
	}
	
	public static String[] partition(String arg, int n) {
		String[] res = new String[n];
		for(int i=0; i<n; i++) res[i] = "";
		
		for(int i=0; i<arg.length(); i++) {
			res[i%n] += arg.charAt(i);
		}
		
		return res;
	}
	
	public static int[] absFreqs(String arg) {
		int[] f = new int[26];
		for(int i=0; i<arg.length(); i++) {
			f[arg.charAt(i)-65]++;
		}
		return f;
	}
	
	/*
	public static void main(String[] args) {
		String plain = "LIEBERALT";

		String cipher1 = caesar(plain, 3, true);
		System.out.println( cipher1 );
		System.out.println( caesar( cipher1, 3, false) );		
		
		String cipher2 = vigenere(plain, "CODE", true);
		System.out.println( cipher2 );	
		System.out.println( vigenere( cipher2, "CODE" , false) );
	}
	*/
}
