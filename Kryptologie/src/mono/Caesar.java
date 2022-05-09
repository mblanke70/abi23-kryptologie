package mono;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;

public class Caesar 
{	
	public static final double[] freqDE =
		{ 
		//	A		B		C		D		E		F		G		H		I		
			.0651, 	.0189, 	.0306, 	.0508, 	.1740, 	.0166,	.0301,	.0476, 	.0755, 	
		//	J		K		L		M		N		O		P		Q		R		
			.0027, 	.0121, 	.0344,	.0253,	.0978,	.0251, 	.0079, 	.0002,	.0700,	
		//	S		T		U		V		W		X		Y		Z
			.0727, 	.0615,	.0435,	.0067, 	.0189,	.0003,	.0004, 	.0113
		}; 
	
	public static final double[] freqEN = 
	{
	//	A		B		C		D		E		F		G		H		I		
		.08167, .01492, .02782, .04253, .12702, .02228, .02015,	.06094, .06966, 
	//	J		K		L		M		N		O		P		Q		R		
		.00153, .00772, .04025, .02406, .06749,	.07507, .01929, .00095, .05987, 
	// 	S		T		U		V		W		X		Y		Z
		.06327, .09056, .02758,	.00978, .02360, .00150, .01974, .00074
	};		
	
	public static final double[] freqLA =
	{
	//	A		B		C		D		E		F		G		H		I		
		.0889,  .0158, .0399, 	.0277, 	.1138, 	.0093, 	.0121, 	.0069, 	.1144, 
	//	J		K		L		M		N		O		P		Q		R		
		.00001,	.00001, .0315, .0538, 	.0628, 	.0540, 	.0303, 	.0151, 	.0667,
	// 	S		T		U		V		W		X		Y		Z
		.0760,  .0800, .0846, 	.0096, 	.00001,	.0060, 	.0007, 	.0001
	};

	public static int[] absFreq(String text)
	{
		int[] F = new int[26];					
		
		for(int i=0; i<text.length(); i++)		
			F[text.charAt(i) - 65]++;
		
		return F;
	}
	
	public static double[] relFreq(String text)
	{
		int[] F = absFreq(text);
		
		double[] f = new double[26];
		for(int i=0; i<26; i++)
			f[i] = Math.round((double) F[i]/text.length() * 10000.0) / 100.0;
			
		return f;
	}
	
	public static String decrypt(String cipher, int key)
	{
		StringBuilder plain = new StringBuilder();
		
		for(int i=0; i<cipher.length(); i++)
			plain.append( (char) (((cipher.charAt(i) - 65 - key + 26) % 26) + 65) );
		
		return plain.toString();
	}

	public static String encrypt(String plain, int key)
	{
		StringBuilder cipher = new StringBuilder();
		
		for(int i=0; i<plain.length(); i++)
			cipher.append( (char) (((plain.charAt(i) - 65 + key) % 26) + 65) );
		
		return cipher.toString(); 
	}
	
	public static void chiSquare(String cipher)
	{
		Map<Double, Integer> ranking = new TreeMap<Double, Integer>();
		
		int[] F = absFreq(cipher);
		int N   = cipher.length();
		
		for(int j=0; j<26; j++)
		{
			double sum = 0;
			for(int i=0; i<26; i++)
				sum += Math.pow(F[(i+j)%26]-freqDE[i]*N, 2)/(freqDE[i]*N);

			ranking.put(sum, j);
		}
		
		for(Map.Entry<Double, Integer> entry : ranking.entrySet())
			System.out.print((char) (entry.getValue()+65) + "\t" + entry.getKey() + "\t");
		
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		String caesar = "VENIVIDIVICI";
		String caesar_cipher = encrypt(caesar, 3);
		
		chiSquare(caesar_cipher);

		
/*
		String plain = "VATERUNSERIMHIMMELGEHEILIGTWERDEDEINNAMEDEINREICHKOMME" + 
					   "DEINWILLEGESCHEHEWIEIMHIMMELSOAUFERDEN";
		
		
		
		
		System.out.println(plain.length());
		
		String cipher = encrypt(plain, 9);
*/		
		

		//chiSquare(caesar_cipher);
		/*
		System.out.println(cipher);
		System.out.println(Arrays.toString(F(cipher)));

		chiSquare(cipher);
		
		String plain_decrypted = decrypt(cipher, 9);
		
		System.out.println(plain_decrypted);

		/*
		String cipher1 = "AOLJHLZHYJPWOLYPZVULVMAOLLHYSPLZARUVDUHUKZPTWSLZAJPWOL" + 
						 "YZPAPZHAFWLVMZBIZAPABAPVUJPWOLYPUDOPJOLHJOSLAALYPUAOLW" +
						 "SHPUALEAPZZOPMALKHJLYAHPUUBTILYVMWSHJLZKVDUAOLHSWOHILA"; 
		
		System.out.println(cipher1);
		
		int[] f = freq(cipher1);
		System.out.println(Arrays.toString(f));
		
		chiSquare(f);
		
		System.out.println(decrypt(cipher1, 7));
		*/
	}
	
	
	
}