package enigma19;

public class Rotor {

	public int[][] wiring; // wiring[0] : RTL, wiring[1] : LTR
	public int pos; // 0..25
	public int carrypos; // 0..25
	public int ringstellung; // 0..25
	
	public Rotor(String w, int pos)
	{
		carrypos   = pos;
		wiring = new int[2][w.length()];
		
		for(int i=0; i<w.length(); i++)
		{
			wiring[0][i] = (w.charAt(i) - 65 - i + 26) % 26;
			wiring[1][w.charAt(i) - 65] = (26 - wiring[0][i]) % 26;
		}
	}
	
	public void step()   	    { pos = (pos + 1) % 26; }
	public int  getPos() 	    { return pos; }
	public void setPos(int pos) { this.pos = pos; }
	public int  getCarryPos()   { return carrypos; }
	public void setRingstellung(int pos) { ringstellung = pos; }
	
	// dir=0: rechts nach links
	// dir=1: links nach rechts
	public char encrypt(char c, int dir)
	{
		return (char) ((c - 65 + wiring[dir][(c-65+pos-ringstellung+26)%26])%26 + 65);
	}	
}
