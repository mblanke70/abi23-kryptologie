import java.util.ArrayList;
import java.util.Arrays;

public class VigenereBrechenleo {

	static String cipher = ""; // COMMENT
	static String plain = "";
	
	final static double[] DEUTSCH = { 6.51, 1.89, 3.06, 5.08, 17.41, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53,
			9.78, 2.51, 0.79, 0.02, 7.00, 7.89, 6.15, 4.35, 0.67, 1.89, 0.03, 0.04, 1.13 };

	// COMMENT
	public static String readTextFromFile(String dateiname) {
		String text = "";

		// TODO

		return text;
	}

	// COMMENT
	public static int ggt(int a, int b) {
		if (b == 0) {
			return a;
		}
		if (b > a) {
			return ggt(b, a);
		}
		return ggt(a % b, b);
	}

	// COMMENT
	public static int calcKeywordLength(String cipher, int min, int max) {
		ArrayList<Integer> distance = new ArrayList<Integer>(); // COMMENT
		cipher = cipher.toUpperCase();
		for (int l = min; l < max; l++) { // COMMENT
			for (int spos = 0; spos < cipher.length() - l + 1; spos++) { // COMMENT
				String s = cipher.substring(spos, spos + l); // COMMENT
				for (int i = spos + l; i < cipher.length(); i++) { // COMMENT
					if (cipher.startsWith(s, i)) {
						if (!distance.contains(i - spos)) {
							distance.add(i - spos);
						}
					}
				}
			}
		}
		System.out.print("Gefundene Abstände: " + distance + "\n");

		int ggt = distance.get(0);
		for (int i = 1; i < distance.size(); i++) { // COMMENT
			ggt = ggt(ggt, distance.get(i));
		}

		System.out.println("Länge des Schlüsselwortes: " + ggt);
		return ggt;
	}

	// COMMENT
	public static int[] calcFreqAbs(String cipher) {
		cipher = cipher.toUpperCase();
		int[] freqAbs = new int[26];
		for (int i = 0; i < cipher.length(); i++) {
			freqAbs[(cipher.charAt(i) - 65)]++;
		}
		return freqAbs;
	}

	// COMMENT
	public static double[] calcFreqRel(String cipher) {
		cipher = cipher.toUpperCase();
		int[] freqAbs = calcFreqAbs(cipher);
		double[] freqRel = new double[26];
		for (int i = 0; i < freqAbs.length; i++) {
			freqRel[i] = ((double) freqAbs[i] / cipher.length()) * 100;
		}
		return freqRel;
	}

	// COMMENT
	public static String calcKeyword(String cipher, int keylength) {
		String keyword = "";
		String[] splitCipher = new String[keylength]; // COMMENT
		
		// COMMENT
		for (int keypos = 0; keypos < keylength; keypos++) {
			splitCipher[keypos] = "";
			for (int i = keypos; i < cipher.length(); i += keylength) {
				splitCipher[keypos] += cipher.charAt(i);
			}
		}

		System.out.println(splitCipher[0]);
		// COMMENT
		
		// TODO: Für jeden Teilstring eine Häufigkeitsanalyse durchführen und daraus
		// jeweils die Caesar-Verschiebung (=Schlüsselbuchstabe) bestimmen
		int[] verschiebungen= new int[keylength];
		for(int i=0; i<keylength; i++) {
			verschiebungen[i] = testmethod(splitCipher[i]);
		}
		
		System.out.println(Arrays.toString(verschiebungen));
		
		// TODO

		// TODO: Schlüsselbuchstaben zum Schlüsselwort zusammensetzen
		String plaintemp="";
		for(int i=0; i<keylength; i++) {
			char e = (char) (verschiebungen[i] + 65);
			plaintemp += (char) ( ( cipher.charAt( i ) - 65 + verschiebungen[i] ) % 26 + 65);
			
		}
		System.out.println("plaintemp: "+plaintemp);
		
		System.out.println("Schlüsselwort: " + keyword);
		return keyword;
	}

	public static int testmethod(String splitCipher) {
		double[] freqRel = calcFreqRel(splitCipher);
		
		
		double[] gesamtabstand = new double[26];
		for (int i = 0; i < 26; i++) {
			double value = 0;
			for (int k = 0; k < 26; k++) {
				value += Math.abs(DEUTSCH[i]-freqRel[(k+i)%26]);
			}
			gesamtabstand[i] = value;
		}

		System.out.println(gesamtabstand[0]);

		int verschiebung = 0;
		double testforsmallest=Math.abs(gesamtabstand[0]);
		for (int i = 0; i < 26; i++) {
			if (Math.abs(gesamtabstand[i]) < testforsmallest) {
				testforsmallest = Math.abs(gesamtabstand[i]);
				verschiebung = i;	
			}
		}
		System.out.println(Arrays.toString(gesamtabstand));
		return verschiebung;
	}

	public static void main(String[] args) {
		cipher = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
		System.out.print("Geheimtext: " + cipher + "\n");
		
		int keywordlength = calcKeywordLength(cipher, 4, 10); 	// 1. SchlüsselwortlÃ¤nge bestimmen
		String keyword = calcKeyword(cipher, keywordlength); 	// 2. Schlüsselwort bestimmen
		// 3. Geheimtext mit Schlüsselwort entschlüsseln
		System.out.print("Klartext: " + plain + "\n");
	}

}
