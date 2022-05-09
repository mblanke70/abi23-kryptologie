package enigma19;

import java.util.Arrays;

public class MiniRotor {

	public int[][] wiring;  // wiring[0] : RTL, wiring[1] : LTR
	public int pos;	// 0..7
	
	public MiniRotor(String w)
	{
		wiring = new int[2][w.length()];
		
		for(int i=0; i<w.length(); i++)
		{
			wiring[0][i] = (w.charAt(i) - 65 - i + 8) % 8;
			wiring[1][w.charAt(i) - 65] = (8 - wiring[0][i]) % 8;
			
			// wiring[0][i] = w.charAt(i)-(i+65);			// 1,  2, 4, -1, -4, -1, -1, 0
			// wiring[1][w.charAt(i)-65] = -wiring[0][i];	// 4, -1, 1, -2,  1,  1, -4, 0
		}
	}
	

	
	public void step()
	{
		pos = (pos + 1) % 8;
	}
	
	public int getPos()
	{
		return pos;
	}
	
	// dir=0: rechts nach links
	// dir=1: links nach rechts
	public char encrypt(char c, int dir)
	{
		return (char) ((c-65+wiring[dir][(c-65+pos)%8])%8 + 65);
	}
	
	public static void main(String[] args) 
	{	
		MiniRotor right = new MiniRotor("ACEHDBFG");

		System.out.println(Arrays.toString(right.wiring[0]));
		System.out.println(Arrays.toString(right.wiring[1]));
		
		right.step();
		System.out.println(right.encrypt('B', 0));
		right.step();
		System.out.println(right.encrypt('A', 0));
		right.step();
		System.out.println(right.encrypt('G', 0));
		right.step();
		System.out.println(right.encrypt('D', 0));
		right.step();
		System.out.println(right.encrypt('A', 0));
		right.step();
		System.out.println(right.encrypt('D', 0));
		
		
		
		
		
	}	
}
