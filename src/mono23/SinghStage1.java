package mono23;

import java.util.Arrays;

public class SinghStage1 {
									// ABCDEFGHIJKLMNOPQRSTUVWXYZ
	public static String decryptKey = "ciovyblkftqmadzhpsjnurgewx";
	
									// abcdefghijklmnopqrstuvwxyz
	public static String encryptKey = "MFANXIWPBSHGLTCQ";
	
	
	public static void main(String[] args) {

		int [] f = absFreqs2(cipher);
		System.out.println(Arrays.toString(f));

		System.out.println( decrypt(cipher) );
	}
	
	public static String decrypt(String cipher) {
		String plain="";
		
		for(int i=0; i<cipher.length(); i++) {
			char c = cipher.charAt(i);
			if( Character.isLetter(c) ) {
				plain += decryptKey.charAt(c-65);
			} else {
				plain += c;
			}
		}
		
		return plain;
	}

	public static String cipher = 
			
			  "BT JPX RMLX PCUV AMLX ICVJP IBTWXVR CI M LMT'R PMTN, "
			+ "MTN YVCJX CDXV MWMBTRJ JPX AMTNGXRJBAH UQCT JPX "
			+ "QGMRJXV CI JPX YMGG CI JPX HBTW'R QMGMAX; MTN JPX "
			+ "HBTW RMY JPX QMVJ CI JPX PMTN JPMJ YVCJX. JPXT JPX "
			+ "HBTW'R ACUTJXTMTAX YMR APMTWXN, MTN PBR JPCUWPJR "
			+ "JVCUFGXN PBL, RC JPMJ JPX SCBTJR CI PBR GCBTR YXVX "
			+ "GCCRXN, MTN PBR HTXXR RLCJX CTX MWMBTRJ MTCJPXV. "
			+ "JPX HBTW AVBXN MGCUN JC FVBTW BT JPX MRJVCGCWXVR, "
			+ "JPX APMGNXMTR, MTN JPX RCCJPRMEXVR. MTN JPX HBTW "
			+ "RQMHX, MTN RMBN JC JPX YBRX LXT CI FMFEGCT, YPCRCXDXV "
			+ "RPMGG VXMN JPBR YVBJBTW, MTN RPCY LX JPX BTJXVQVXJMJBCT "
			+ "JPXVXCI, RPMGG FX AGCJPXN YBJP RAMVGXJ, MTN PMDX M "
			+ "APMBT CI WCGN MFCUJ PBR TXAH, MTN RPMGG FX JPX JPBVN "
			+ "VUGXV BT JPX HBTWNCL. JPXT AMLX BT MGG JPX HBTW'R YBRX "
			+ "LXT; FUJ JPXE ACUGN TCJ VXMN JPX YVBJBTW, TCV LMHX "
			+ "HTCYT JC JPX HBTW JPX BTJXVQVXJMJBCT JPXVXCI. JPXT YMR "
			+ "HBTW FXGRPMOOMV WVXMJGE JVCUFGXN, MTN PBR ACUTJXTMTAX "
			+ "YMR APMTWXN BT PBL, MTN PBR GCVNR YXVX MRJCTBRPXN. TCY "
			+ "JPX KUXXT, FE VXMRCT CI JPX YCVNR CI JPX HBTW MTN PBR "
			+ "GCVNR, AMLX BTJC JPX FMTKUXJ PCURX; MTN JPX KUXXT RQMHX "
			+ "MTN RMBN, C HBTW, GBDX ICVXDXV; GXJ TCJ JPE JPCUWPJR "
			+ "JVCUFGX JPXX, TCV GXJ JPE ACUTJXTMTAX FX APMTWXN; JPXVX "
			+ "BR M LMT BT JPE HBTWNCL, BT YPCL BR JPX RQBVBJ CI JPX "
			+ "PCGE WCNR; MTN BT JPX LAMER CI JPE IMJPXV GBWPJ MTN "
			+ "UTNXVRJMTNBTW MTN YBRNCL, GBHX JPX YBRNCL CI JPX WCNR, "
			+ "YMR ICUTN BT PBL; YPCL JPX HBTW TXFUAPMNTXOOMV JPE IMJPXV, "
			+ "JPX HBTW, B RME, JPE IMJPXV, LMNX LMRJXV CI JPX LMWBABMTR, "
			+ "MRJVCGCWXVR, APMGNXMTR, MTN RCCJPRMEXVR; ICVMRLUAP MR MT "
			+ "XZAXGGXTJ RQBVBJ, MTN HTCYGXNWX, MTN UTNXVRJMTNBTW, "
			+ "BTJXVQVXJBTW CI NVXMLR, MTN RPCYBTW CI PMVN RXTJXTAXR, "
			+ "MTN NBRRCGDBTW CI NCUFJR, YXVX ICUTN BT JPX RMLX NMTBXG, "
			+ "YPCL JPX HBTW TMLXN FXGJXRPMOOMV; TCY GXJ NMTBXG FX AMGGXN, "
			+ "MTN PX YBGG RPCY JPX BTJXVQVXJMJBCT. JPX IBVRJ ACNXYCVN BR "
			+ "CJPXGGC.";

	public static int[] absFreqs1(String s) {
		for(char a='A'; a<='Z'; a++) {
			int z=0;
			for(int i=0; i<s.length(); i++) {
				if(a == s.charAt(i)) {
					z++;
				}
			}
			System.out.println(a + " : " + z);
		}
		return null;
	}
	
	public static int[] absFreqs2(String s) {
		int[] counter = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLetter(c)) { // c>=65 && c<=90
				counter[ c-65 ]++;
			}
		}
		
		return counter;
	}
	
	
	

}
