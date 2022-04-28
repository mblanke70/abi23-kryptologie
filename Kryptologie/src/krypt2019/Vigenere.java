package krypt2019;

import java.util.Arrays;

import krypt2019.Caesar;

public class Vigenere {

	public static String encrypt(String plain, String keyword) {
		String cipher = "";
		for(int i=0; i<plain.length(); i++) {
			cipher += Caesar.encrypt(plain.charAt(i)+"", keyword.charAt(i%keyword.length())-65);
		}
		return cipher;
	}
	
	public static String decrypt(String cipher, String keyword) {
		String plain = "";
		for(int i=0; i<cipher.length(); i++) {
			plain += Caesar.decrypt(cipher.charAt(i)+"", keyword.charAt(i%keyword.length())-65);
		}
		return plain;
	}
	
	public static void findDuplicates(String text) {
		for(int l=3; l<8; l++) {
			for(int j=0; j<text.length()-l+1; j++) {
				String pattern = text.substring(j, j+l);
				for(int i=j+1; i<text.length(); i++) {
					if(text.startsWith(pattern, i))
						System.out.println(pattern + " " + j + " " + i + " : " + (i-j));
				}
			}
		}
	}
	
	public static String[] partition(String cipher, int keylength) {
		String[] parts = new String[keylength];
		for(int i=0; i<keylength; i++) parts[i] = "";
		
		for(int i=0; i<cipher.length(); i++) {
			parts[i%keylength] += cipher.charAt(i);
		}
		
		return parts;
	}
	
	public static String[] findKey(String[] parts) {
		String[] key = new String[parts.length];
		for(int i=0; i<parts.length; i++) key[i] = "";

		for(int i=0; i<parts.length; i++) {
			key[i] += Caesar.caesarKey(parts[i]).values();
		}
		
		return key;
	}
	
	public static void main(String[] args) {
	
		String text1 = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMM" + 
					   "ZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUE" + 
					   "KUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBV" + 
					   "KLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODS" + 
					   "RVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJC" + 
					   "NPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOA" +
					   "NWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGU" + 
					   "YSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZ" + 
					   "SWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWP" + 
					   "GOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVK" +
					   "VLWZKV";
		
		String cipher1 = "VPTNVFFUNTSHTARPTYMJWZIRAPPLJMHHQVSUBWLZZYGVTYITARPTYIOUGXIUYDTGZHHVVMUMSHW" + 
					     "KZGSTFMEKVMPKSWDGBILVJLJMGLMJFQWIOIIVKNULVVFEMIOIEMOJTYWDSAJTWMTCGLUYSDSUMF" +
					     "BIEUGMVALVXKJDUETUKATYMVKQZHVQVGVPTYTJWWLDYEEVQUHLULWPKT";
		// Keylength: 7; Key: CIPHERS 

		String cipher2 = "SCBPEHPEYNRRXRYYXVMHYNRRXBFZQRXKIMPHXDYNRRXFYQHFKLU";
		// Keylength: 3 oder 6?
				
		
		String cipher3 = "WZPKQQJCWVHKNXCLERKNBQMAMSWZPBDAXNVQXFNXKPKQQJCWQKEUAZPUMVEAGZMSFGRWYRWOWBO" + 
					     "KXJBCPNCAYTZIIXTZILPGAYKMCVLFXWEIFLMRKRFMYWVCEMLQRKUEYSZLYDZFQNVNNRLOFYKQQJ" +
					     "CWVHKNLTSEMNYANKAVJGLYDCAYTZIIXTTELLXKYVQDWIWXEDTZWLTMXNRILTSWZWWQMXTRIXIDF" +
					     "NJGDTSXVYUVQARKNBQMAHNXBCYOLIPZKILNXDTTCWLBQMAIWAVTTCWLNQQXRJGXPHDAGNVUHQRN" +
					     "ETKZLCXVGTIMKVYDCAYTZIIXTTELLXKYZCKLMFEJREFWHBXSXPJKZYDDJEAGZMSLKRAHHWXJALK" +
					     "IHAVYDDJMRKRXVMXZEDDJEXUWNRNDREINFTDUJBIQAREKQQJCWQKEUAZPUMVEAGZMSFGRWYRWQN" +
					     "ZNXRITYPRZMWQIVLHJYVYSHNYDVNHJKXEDIUWEAGZMSQHXTEAWTNQMARJM";
		// Keylength: 13; Key:  
		
		
		String cipher4 = "RCYDAAHVMETFXHAXTHQKDAACJRCHAXPSOLGRVCFOEHEUFTSBVRNKUIBQAXTFOLGRVCFOEHEYTOQ" +
					     "KHHYHBRCHRHEXUZNRFEIMYHAXTFPFHFWSXMBFUYPJZBVPIOFEYOBMDMQDWVMEEUBVRLYVFWOBMR" +
					     "FILUQYYFZQZRXPSEQLEVEFDXXFIOFDBURHEXUZNRFETUZKMOPJZBPAYFFZPWNYCLQOHAWZEQCRE" +
					     "N";
		// Keylength: 7, 14; Key:  

		
		findDuplicates(cipher3);
		
		String[] parts = partition(cipher3, 13);
		
		String[] key = findKey(parts);
		for(String s : key) System.out.println(s);
		
		//System.out.println(decrypt(text4, "FXN"));
	}
}
