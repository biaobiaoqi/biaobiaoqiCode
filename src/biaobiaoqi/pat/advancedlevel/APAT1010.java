package biaobiaoqi.pat.advancedlevel;
import java.util.Scanner;

//The largest radix is not 36! upper bound can be the value of the one whose radix is known.
//how to keep smallest radix with binarysearch? 
public class APAT1010 {
	public static long n1 ;
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str1 = cin.next();
		String str2 = cin.next();
		int tag = cin.nextInt();
		long radix = cin.nextLong();
		
		if (str1.equals(str2) ) {
			if (str1.equalsIgnoreCase("1")) {
				System.out.println(2);
			}else {
				System.out.println(radix);	
			}
			
		}else {
			if (tag == 2) {
				String string = str2;
				str2 = str1;
				str1 = string;
			}
			
			n1 = str2Num(str1, radix);
			int min = 0;
			for (int i = 0; i != str2.length(); i ++) {
				int tmp = char2int(str2.charAt(i));
				if (tmp > min) {
					min = tmp;
				}
			}
			
			long resultRadix = binarySearch(str2, min, (n1 > min)?n1:min , n1);
			if (resultRadix == -1) {
				System.out.println("Impossible");
			}else {
				System.out.println(resultRadix);
			}
		}
	}
	
	public static long str2Num(String str, long radix ){
		long result = 0;
		long radixTmp = 1;
		for (int i = str.length()-1 ; i >= 0; i --) {
			result += char2int(str.charAt(i)) * radixTmp;
			radixTmp *= radix;
		}
		return result;
	}
	
	public static int char2int(char ch) {
		int v;
		if (ch <= '9' && ch >= '0') {
			v = ch - '0' ;
		}else {
			v = ch - 'a' + 10;
		}
		return v;
	}
	
	public static long binarySearch(String str, long lower, long high, long traget){
		long middle;
		long val;
		
		while (lower <= high) {
			middle = (lower + high)/2;
			val = str2Num(str, middle);
			
			if (val < traget) {
				lower = middle + 1;
			}else if (val > n1) {
				high = middle - 1;
			}else {
				return middle;
			}
		}
		
		return -1;
	}
}