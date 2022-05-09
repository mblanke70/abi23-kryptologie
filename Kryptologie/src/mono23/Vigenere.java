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
	
	public static String encrypt(String arg, String keyword) {
		String res = "";
	
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			int k = keyword.charAt( i % keyword.length() ) - 65;
<<<<<<< HEAD
<<<<<<< HEAD
			
			if( encrypt )
				res += shift(c, k);
			else
				res += shift(c, 26-k);
=======
=======
>>>>>>> parent of 418c89d (...)
			res += shift(c, k);
>>>>>>> parent of 418c89d (...)
		}
		
		return res;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
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
		
		String[] gruppen = split(cipherB, 5);
		System.out.println( Arrays.toString(gruppen) );
		
		for(int i=0; i<5; i++) {
			System.out.println( (i+1) + ". Buchstabe : " + Arrays.toString( absFreqs(gruppen[i])) );
		}
	}
	
	public static String[] split(String arg, int n) {
		String[] res = new String[n];
		for(int i=0; i<n; i++) res[i] = "";
		
=======
	public static String decrypt(String arg, String keyword) {
		String res = "";
	
>>>>>>> parent of 418c89d (...)
=======
	public static String decrypt(String arg, String keyword) {
		String res = "";
	
>>>>>>> parent of 418c89d (...)
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			int k = keyword.charAt( i % keyword.length() ) - 65;
			res += shift(c, 26-k);
		}
		
		return res;
	}
<<<<<<< HEAD

	// SCUBA
	//
	//  A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   P   Q   R   S   T   U   V   W   X   Y   Z
	// ======================================================================================================
	// [7,  0,  0,  10, 3,  5,  6,  2,  3,  7,  11, 4,  9,  1,  0,  0,  0,  0,  13, 3,  3,  3,  24, 1,  4,  2]
	//  I   J   K   L   M   N   O   P   Q   R   S   T   U   V   W   X   Y   Z   A   B   C   D   E   F   G   H
	// [0,  0,  8,  0,  3,  2,  26, 0,  2,  4,  8,  0,  0,  9,  8,  8,  7,  3,  0,  4,  9,  7,  8,  5,  0,  0]
	//          A   B   C   D   E          
	// [1,  3,  11, 1,  0,  8,  3,  5,  6,  5,  1,  6,  15, 7,  8,  2,  0,  1,  0,  1,  10, 3,  0,  4,  19, 1]
	//                                                                                  A   B   C   D   E      
	// [0,  11, 2,  4,  6,  17, 1,  3,  0,  6,  0,  0,  7,  5,  6,  5,  2,  2,  5,  13, 12, 7,  2,  0,  3,  2]
	//      A   B   C   D   E                                                                                   
	// [8,  1,  7,  3,  27, 0,  3,  1,  5,  0,  0,  7,  3,  10, 4,  1,  2,  12, 9,  8,  9,  0,  0,  0,  0,  0]
	//  A   B   C   D   A                                                                                           
	
<<<<<<< HEAD
	public static int[] absFreqs(String s) {
		int[] counter = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLetter(c)) { // c>=65 && c<=90
				counter[ c-65 ]++;
			}
		}
		
		return counter;
=======
	
=======
>>>>>>> parent of 418c89d (...)
	public static void main(String[] args) {
		String plain = "LIEBERALT";

		String cipher1 = caesar(plain, 3);
		System.out.println( cipher1 );
		System.out.println( caesar( cipher1, 23 ) );
		
		String cipher2 = encrypt(plain, "CODE");
		System.out.println( cipher2 );	
		System.out.println( decrypt( cipher2, "CODE" ) );
<<<<<<< HEAD
>>>>>>> parent of 418c89d (...)
=======
>>>>>>> parent of 418c89d (...)
	}
	
	/* cipherA :
	EINE GRUPPE VON PERSONEN TEILT SICH SO IN DREI GRUPPEN DASS JEDER ZU GENAU EINER GRUPPE
	GEHOERT DIE ERSTE GRUPPE NENNT SICH DIE WAHREN WEIL SIE JEDE FRAGE WAHRHEITSGEMAESS
	BEANTWORTET DIE ZWEITE GRUPPE NENNT SICH DIE LUEGNER WEIL SIE JEDE FRAGE FALSCH BEANTWORTET
	DIE DRITTE GRUPPE NENNT SICH DIE WECHSLER WEIL SIE AUFEINANDER FOLGENDE FRAGEN ABWECHSELND
	WAHR UND FALSCH BEANTWORTET DABEI IST ABER NICHT FESTGELEGT OB JEWEILS DIE ERSTE FRAGE EINER
	SERIE VON FRAGEN RICHTIG ODER FALSCH BEANTWORTET WIRD JEDE PERSON ANTWORTET AUF EINE FRAGE
	NUR MIT JA ODER NEIN FRAGEN DIE NICHT MIT JA ODER NEIN BEANTWORTET WERDEN KOENNEN SIND NICHT
	ZUGELASSEN VON EINER BELIEBIGEN PERSON SOLL MAN DURCH FRAGEN DIE SICH NUR AUF DIE ZUGEHOERIGKEIT
	ZU EINER DER GRUPPEN BEZIEHEN HERAUSBEKOMMEN ZU WELCHER GRUPPE SIE GEHOERT WIEVIELE FRAGEN MUSS
	MAN MINDESTENS STELLEN UND WELCHE FRAGEN KOENNTE MAN STELLEN
	*/
}
