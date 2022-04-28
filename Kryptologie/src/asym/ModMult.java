package asym;

import java.math.BigInteger;
import java.util.Arrays;

public class ModMult {
	
	public static BigInteger ea(BigInteger a, BigInteger b) {
		if(b.compareTo(BigInteger.ZERO) == 0) {
			return a;
		} else {
			return ea(b, a.mod(b));
		}		
	}

	public static BigInteger[] eea(BigInteger a, BigInteger b) {
		if(b.compareTo(BigInteger.ZERO) == 0) {
			return new BigInteger[] { a, BigInteger.ONE, BigInteger.ZERO };
		} else {	
			BigInteger[] result = eea(b, a.mod(b));
			
			BigInteger ggT = result[0]; 
			BigInteger x   = result[1];
			BigInteger y   = result[2];
			
			return new BigInteger[] { ggT , y , x.subtract(y.multiply(a.divide(b))) };
		}		
	}
	
	public static BigInteger modInv(BigInteger a, BigInteger b) {
		return eea(a,b)[2].add(a).mod(a);
	}
	
	public static BigInteger mult(BigInteger a, BigInteger b) {
		BigInteger s = BigInteger.ZERO;
		
		while(b.compareTo(BigInteger.ZERO)>0) {
			if(b.getLowestSetBit()==0) {
				s = s.add(a);
			}
			
			a = a.shiftLeft(1);
			b = b.shiftRight(1);
		}
		
		return s;
	}
	
	public static BigInteger pot(BigInteger a, BigInteger b) {
		BigInteger s = BigInteger.ONE;
		
		while(b.compareTo(BigInteger.ZERO)>0) {
			if(b.getLowestSetBit()==0) {
				s = mult(s,a);
			}
			
			a = mult(a,a);
			b = b.shiftRight(1);			
		}
		
		return s;
	}
	
	public static BigInteger modPot(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger s = BigInteger.ONE;
		
		while(b.compareTo(BigInteger.ZERO)>0) {
			if(b.getLowestSetBit()==0) {
				s = mult(s,a).mod(n);
			}
			
			a = mult(a,a).mod(n);
			b = b.shiftRight(1);			
		}
		
		return s;
	}	
	
	public static void main(String[] args) {

		
	
		BigInteger e = new BigInteger("13453200347566479345");
		
		
		BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		
		System.out.println(modInv(phi, e));
		
		BigInteger d = e.modInverse(phi);
		System.out.println(d);
		
		BigInteger c = new BigInteger("96869613754622061477140922254355882905759991124574319874695120930816298225145708356931476622883989628013391990551829945157815154");
		
		System.out.println(c.modPow(d, N));
		
		//BigInteger[] result = eea(N,e);
		//System.out.println(result[2]);
		
		//System.out.println(modInv(N,e));
		
		//BigInteger a = new BigInteger("27");
		//BigInteger b = new BigInteger("104");
		//BigInteger x = new BigInteger("3");
		//BigInteger y = new BigInteger("4");
		
		//System.out.println(mult(a,b));
	}
}