package vigenere;

import mono.Caesar;

public class Vigenere {

	public static String decrypt(String cipher, String keyword)
	{
		String plain = "";
		
		for(int i=0; i<cipher.length(); i++)
			plain += Caesar.decrypt(cipher.charAt(i) +"", keyword.charAt(i%keyword.length()) - 65);
		
		return plain; 
	}
	
	public static String encrypt(String plain, String keyword)
	{
		String cipher = "";
		
		for(int i=0; i<plain.length(); i++)
			cipher += Caesar.encrypt(plain.charAt(i) +"", keyword.charAt(i%keyword.length()) - 65);
		
		return cipher; 
	}
	
	public static String[] extractCeasarCiphers(String cipher, int keylength)
	{
		String[] ciphers = new String[keylength];
		
		for(int j=0; j<keylength; j++)
			ciphers[j] = "";
		
		for(int i=0; i<cipher.length(); i++)
			ciphers[i%keylength] += cipher.charAt(i);
		
		return ciphers;
	}
	
	public static void findDuplicates(String t)
	{
		for(int j=0; j<t.length()-(3+1); j++) {
			String pattern = t.substring(j, j+3);
			for(int i=j+3; i<t.length(); i++)
				if(t.startsWith(pattern, i))
					System.out.println(pattern + "\tp1:" + j + "\tp2:" + i + "\td:" + (i-j));
		}
	}
	
	public static void search(String cipher) {
		for (int k = 3; k < cipher.length(); k++) {

			for (int j = 0; j < cipher.length() - k - 1; j++) {
				String pattern = cipher.substring(j, j + k);

				for (int i = j + k; i < cipher.length(); i++) {

					if (cipher.startsWith(pattern, i)) {
						System.out.println(i + " " + pattern + " Abstand: " + (i - j));
					}
				}
			}
		}
	}
	
	public static void search2(String cipher) 
	{
		for(int l=2; l<cipher.length()/2; l++)
		{
			for(int j=0; j<cipher.length()-(l-1); j++)
			{
				String pattern = cipher.substring(j, j+l);
				for (int i = j+l; i < cipher.length(); i++) 
				{
					if (cipher.startsWith(pattern, i)) 
					{
						System.out.println(j + " " + i + " " + pattern + " Abstand: " + (i - j));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		String t = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";
		String caro1 = "NIXRGUVFSCSXKPNOYUOILSIVXPSXTLBLRSOSXDXHRSYCAKTBNR";
		String caro2 = "WZPKJCQQLVHKNXCLEKWUPFMAMSWZPBWMEBKQXFNXKPKJCQQLQKEUAZPUFHLOVZMSFGRWYKIVKQOKXJBCPNVMFHOIIXTZILPZMFYBCVLFXWEIYXTFZRFMYWVCEFXXFZUEYSZLYDSRXBKNNRLOFYKJCQQLVHKNLTSEFZFOCKAVJGLYDVMFHOIIXTTELLQWFJFDWIWXEDTSISHBXNRILTSWSIDEBXTRIXIDFGVNRISXVYUVQAKWUPFMAHNXBCYHXPDOKILNXDTTVISPFMAIWAVTTVISBFQXRJGXPHWMNBKUHQRNETKSXJLKGTIMKVYDVMFHOIIXTTELLQWFNRKLMFEJREYIOPMSXPJKZYDWVLOVZMSLKRAHAIEXPLKIHAVYDWVTFZRXVMXZEDWVLLJWNRNDREIGRARJJBIQAREKJCQQLQKEUAZPUFHLOVZMSFGRWYKIXBONXRITYPRSYDEXVLHJYVYSAZFRKNHJKXEDINILOVZMSQHXTETIABFMARJM";
		//
		search2(caro1);
		//search(caro2);
		
		String cipher = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOFEKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGGQEUJYOTVGGBRUJYS";
		
		for(String c : extractCeasarCiphers(caro2, 13))
		{
			System.out.println(c);;
			//Caesar.chiSquare(c);
		}
		for(int k=0; k<39; k++)
			System.out.print("TRLASEBXXKTEF");
		System.out.println();
		System.out.println(decrypt(caro2, "TRLASEBXXKTEF"));
	}

}
