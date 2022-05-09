import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Ceasar {
	
	

	public static String encrypt(String klar, int key)
	{
		String geheim = "";
		for (int i=0; i<klar.length(); i++)
		{
			char k = klar.charAt(i);
		
		
			char g = (char)(((k - 65 + key )% 26 ) + 65);
			
			geheim +=g;
		}
		
		
		return geheim;
	}
	
	public static String decrypt(String geheim, int key)
	{
		String klaar = "";
		for (int i=0; i<geheim.length(); i++)
		{
			char k = geheim.charAt(i);
			
			char g = (char)(((k - 65 + 26 - key )% 26 ) + 65);
			
			klaar += g;
		}
		return klaar;
		
	}
	public static int [] Freq(String text)
	{
		int[] h = new int[26];
		for (int i=0; i < text.length(); i ++)
		{
			char o = text.charAt(i);
			int x = o - 65; 
			
			h[x] ++;
		}
		
		
		return h;
	}
	
	public static double [] freq(String text)
	{
		int[] F = new int[26];

		for (int i=0; i < text.length(); i ++)
		{
			F[text.charAt(i)-65]++;
		}
		
		double[] f = new double[26];
		
		for (int i=0; i < 26; i ++)
		{
			f[i] = (double) F[i] / text.length();
		}
		
		
		return f;
	}
	
	public static final double[] freqAvgDE =
        { 
        //  A       B       C       D       E       F       G       H       I       
            .0651,  .0189,  .0306,  .0508,  .1740,  .0166,  .0301,  .0476,  .0755,  
        //  J       K       L       M       N       O       P       Q       R       
            .0027,  .0121,  .0344,  .0253,  .0978,  .0251,  .0079,  .0002,  .0700,  
        //  S       T       U       V       W       X       Y       Z
            .0727,  .0615,  .0435,  .0067,  .0189,  .0003,  .0004,  .0113
        }; 
	
	
	public static void Ren(String text)
	{
		TreeMap<Double, Integer> ranking = new TreeMap<Double, Integer>();
		
		int[] f_cipher = Freq(text);
		int N = text.length();
		
		double sum;
		for (int j=0; j < 26; j ++)
		{
			sum=0;
			
			for (int i=0; i < 26; i ++)
			{
				double x = freqAvgDE[i]*N;
				int y = f_cipher[(i+j)%26];
				sum += Math.pow((x-y), 2)/x;
				
			}
			
			ranking.put(sum, j);
		}
		
		for(Map.Entry<Double, Integer> entry : ranking.entrySet())
			System.out.print(entry.getValue() + ":" + entry.getKey() + " ");
		
		System.out.println(" ");
	}
	
	public static String Wort(String start)
	{
		String h = " ";
		for ( int i  = 1; i < start.length(); i+=7)
		{

			h += start.charAt(i);

		}

		return h;
	}
	public static void main(String[] args)
	{
	
	String Hellbach = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
	
	String Erste = "PAPENCAURYACDADHPPPTPEOEPTFPPPMCOCYODWPCOYDSWYEDTEZWDPPQTONHTAYEPFZYOEOMCOYYRYPMCWNYSOSPYCPSPKPPZGLDODFSYPW"; // 11
	
	String Zweite = "WDFSVSSSSSSHHSWOWRKHGKWSBQSWRTSHFIBWZGWTSOSFGHRHQUPGHSFFQSVCFSHOTFRTWASSHSSWSJFWGAVRBWCWSINSYIFGSWUASHBSYAZ"; // 14
	
	String Dritte = "TKYOYOTJTXMJKTINRKGYYUKMKNMRKGGKOVZKKOTULHRAICGGNKPJKOOGNXHXJXCAXSKXKOXGKTTIRUHMUGLOAKKZXVOXUCMOXKKGYKJLUGK"; // 6
	
	String Vierte = "MDWTWOLMIOMQOMPZANPOJZHZVLVANTVBBXAEZMITZEVVPWJJBTMQNVMOBNMBRAWNIQZIVBVVBSAPIVMMVVZMZHZHLXMIUMZMBTVVBTEZMVV"; // 8
	
	String Fuenfte = "YGFLAJSJMJZWJFVWAJJWWLOMFAWAJKLVLWAWOSFYSWVVTJWWXWOWJWNWASSWWGJWYLFYABWLOGALKWDFKVSKSMAMWWZMEDMYOWEEWDWSFK"; // 18
	
	String Sechste = "TPGUPWUBGWQGWPKPGCJOCGGRVGTGCEYKGPEEGWFGIEYHGVKTGIGGCTQPINPVFPVKGLGGECKYGGPBUKKRQWIKWIIGTPGUGERGKHWKPGNIPV"; // 2
	
	String Siebete = "BWUPKWZBPWLYWALDQNLHUAPWZSDQNOVLNLOOPMLULOHHHLPUZAPYNZUYVZADLHLUUHPUOVUVYUKBLULLSYLJMLRPNIUIUOWOLYZUZUJLAL"; // 7
	
	
	
	System.out.println(Wort(Hellbach));
	
	System.out.println("");
	
	Ren(Siebete);
	

	}
}
