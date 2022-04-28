package mono;

public class Test {
	public static void main(String[] args)
	{
		char c = 'A';
		char z = (char) (c + 3);
		
		System.out.println(z);
		
		String t = "HALLO";
		for(int i=0; i<t.length(); i++)
		{
			System.out.println(t.charAt(i));
		}
	}
}
