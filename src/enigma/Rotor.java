package enigma;

public class Rotor 
{
	private int[][] wiring;  		// wiring[0] : RTL, wiring[1] : LTR
	private int pos;				// 0..25
	private int übertragpos;		// 0..25
	private int ringstellung;		// 0..25

	public Rotor(String w, int t)
	{
		übertragpos  = t;
		wiring = new int[2][w.length()];
		
		for(int i=0; i<w.length(); i++)
		{
			wiring[0][i] = w.charAt(i)-(i+65);			
			wiring[1][w.charAt(i)-65] = -wiring[0][i];	
		}
	}
	
	public char encrypt(char c, int dir)
	{
		return (char) ( ( (c-65+wiring[dir][(c-65+pos-ringstellung+26)%26]+26)%26 ) +65 );
	}
	
	public void step()                 { pos = (pos+1) % 26; }
	public int  getPos()               { return pos;         }
	public void setPos(int p)          { pos = p;            }
	public int  getÜbertragPos()       { return übertragpos; }
	public void setRingstellung(int r) { ringstellung = r;   }
}
