package enigma19;

public class MiniEnigma 
{	
	public static final MiniRotor right = new MiniRotor("ACEHDBFG");
	public static final MiniRotor mid   = new MiniRotor("FBEAGCHD");
	public static final MiniRotor left  = new MiniRotor("FDEABGCH");
	public static final MiniRotor refl  = new MiniRotor("HFGEDBCA");
			
	public void step()
	{
		right.step();
		
		if(right.getPos() == 0)
		{
			mid.step();
			if(mid.getPos() == 0) 
			{
				left.step();
			}
		}
	}
	
	public String toString()
	{
		String c = "";
		
		c += (char) (left.getPos()  + 65); 
		c += (char) (mid.getPos()   + 65); 
		c += (char) (right.getPos() + 65); 
		
		return c;
	}
	
	public char encrypt(char c)
	{
		step();

		System.out.println(this);

		c = right.encrypt(c, 0);
		c = mid.encrypt(c, 0);
		c = left.encrypt(c, 0);
		c = refl.encrypt(c, 0);
		c = left.encrypt(c, 1);
		c = mid.encrypt(c, 1);
		c = right.encrypt(c, 1);

		return c;
	}
	
	public String encrypt(String plain)
	{
		String cipher = "";
		for(int i=0; i<plain.length(); i++)
		{
			cipher += encrypt(plain.charAt(i));
		}
		
		return cipher;
	}
	
	public static void main(String[] args) 
	{
		MiniEnigma enigma = new MiniEnigma();
		
		String cipher = enigma.encrypt("AACHE");
		System.out.println(cipher);
	}
}
