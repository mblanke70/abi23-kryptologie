package mono;

import java.util.Arrays;

public class MonoKidd {
	
	public static int[] Freq(String text) {
		int[] counter = new int[128];
		
		for(int i=0; i<text.length(); i++) {
			counter[text.charAt(i)]++;
		}
		
		return counter;
	}

	public static void main(String[] args) {
		
		String cipher =
				
			  "53##+305))6*;4826)4#.)4#);806*;48+8$60))85;1#(;:#*"
			+ "8+83(88)5*+;46(;88*96*?;8)*#(;485);5*+2:*#(;4956*2"
			+ "(5*-4)8$8*;4069285);)6+8)4##;1(#9;48081;8:8#1;48+8"
			+ "5;4)485+528806*81(#9;48;(88;4(#?34;48)4#;161;:188;"
			+ "#?;";
		
		
		int[] F = Freq(cipher);
		
		for(int i=0; i<128; i++) {
			if(F[i]>0)
				System.out.println((char) i + " : " + F[i]);
		}
	}

}
