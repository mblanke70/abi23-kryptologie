package krypt2019;

import java.util.Arrays;
import java.util.TreeMap;

public class Caesar {

	public static final double[] freqDE = { 
	//	A		B		C		D		E		F		G		H		I		
		.0651, 	.0189, 	.0306, 	.0508, 	.1740, 	.0166,	.0301,	.0476, 	.0755, 	
	//	J		K		L		M		N		O		P		Q		R		
		.0027, 	.0121, 	.0344,	.0253,	.0978,	.0251, 	.0079, 	.0002,	.0700,	
	//	S		T		U		V		W		X		Y		Z
		.0727, 	.0615,	.0435,	.0067, 	.0189,	.0003,	.0004, 	.0113
	}; 
	
	public static final double[] freqEN = {
	//	A		B		C		D		E		F		G		H		I		
		.08167, .01492, .02782, .04253, .12702, .02228, .02015,	.06094, .06966, 
	//	J		K		L		M		N		O		P		Q		R		
		.00153, .00772, .04025, .02406, .06749,	.07507, .01929, .00095, .05987, 
	// 	S		T		U		V		W		X		Y		Z
		.06327, .09056, .02758,	.00978, .02360, .00150, .01974, .00074
	};		
	
	public static String encrypt(String plain, int key) {
		String cipher = "";
		
		for(int i=0; i<plain.length(); i++)
			cipher += (char ) ( ( (plain.charAt(i) - 65 + key) % 26) + 65);
		
		return cipher; 
	}
	
	public static String decrypt(String cipher, int key) {
		String plain = "";
		
		for(int i=0; i<cipher.length(); i++)
			plain += (char ) ( ( (cipher.charAt(i) - 65 - key + 26) % 26) + 65);
		
		return plain;
	}
	
	public static int[] absFreq(String text) {
		int[] counter = new int[26];
		
		for(int i=0; i<text.length(); i++) {
			counter[text.charAt(i)-65]++;
		}
		
		return counter;
	}
	
	public static double[] relFreq(String text) {
		int[] F = absFreq(text);
		
		double[] f = new double[26];
		for(int i=0; i<26; i++)
			f[i] = (double) F[i]/text.length();
			
		return f;
	}
	
	public static TreeMap<Double, Character> caesarKey(String cipher) {
		//double[] rF = relFreq(cipher);
		int[]    aF = absFreq(cipher);
		int       N = cipher.length();
		TreeMap<Double, Character> ranking = new TreeMap<Double, Character>(); 
		
		for(int j=0; j<26; j++) {
			double sum = 0;
			for(int i=0; i<26; i++) {
				//sum += Math.abs(freqDE[j] - rF[(j+i)%26]);
				sum += Math.abs(freqDE[i] * N - aF[(j+i)%26]);
				// sum += Math.pow(freqDE[i] * N - aF[(i+j)%26], 2)/(freqDE[i]*N);
			}
			
			ranking.put(sum, (char) (j+65));
		}
		
		//System.out.println(Arrays.asList(ranking));
		
		return ranking;
	}
	
	
	public static void main(String[] argv) {
		String cipher2 = "PAPENCAURYACDADHPPPTPEOEPTFPPPMCOCYODWPCOYDSWYEDTEZWDPPQTONHTAYEPFZYOEOMCOYYRYPMCWNYSOSPYCPSPKPPZGLDODFSYPW";
		
		System.out.println(caesarKey(cipher2));

		//System.out.println(decrypt(cipher1,13));
		//System.out.println(encrypt(plain,6));
	}
}
