package biaobiaoqi.pat.advancedlevel;
import java.util.Scanner;

//The largest radix is not 36! upper bound can be the value of the one whose radix is known.
//how to keep smallest radix with binary search? ...we can improve when n > 10,
//there will be only one right answer. It's monotone increasing
//input string of n1, n2 should cut zeros on the head

//6,8,12,13,15,16 -- middle = low --> 6,8,15
public class FUCK_APAT1010 {

	public static String cutZero(String str) {
		int i;
		for ( i = 0; i != str.length(); i ++) {
			if (str.charAt(i) != '0') {
				break;
			}
		}
		if (i != 0) {
			return str.substring(i);
		}else {
			return str;			
		}
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str1 = cin.next();
		String str2 = cin.next();
		int tag = cin.nextInt();
		long radix = cin.nextLong();
		
		str1 = cutZero(str1);
		str2 = cutZero(str2);
		
		if (str1.equals(str2) ) {
			if (str1.equalsIgnoreCase("1")) {
				System.out.println(2);
			}else if (str1.length() == 1){
				System.out.println(radix > str2Num(str1, radix) ?str2Num(str1, radix) + 1: radix );	
			}else {
				System.out.println(radix);	
			}
			
		}else {
			if (tag == 2) {
				String string = str2;
				str2 = str1;
				str1 = string;
			}

			long n1 = str2Num(str1, radix);
			long min = cal(str2);
			long resultRadix = binarySearch(str2, min, (n1 > min)?n1:min , n1);

			if (resultRadix == -1) {
				System.out.println("Impossible");
			}else {
				System.out.println(resultRadix);
			}
		}
	}
	
	public static long cal(String str2) {
		long min = 0;
		for (int i = 0; i != str2.length(); i ++) {
			int tmp = char2int(str2.charAt(i));
			if (tmp + 1 > min) { //it's not tmp, it's tmp + 1
				min = tmp + 1;
			}
		}
		
		return min;
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
//		long middle = lower;
//		long val;
//		while (lower <= high) {
//			val = str2Num(str, middle);
//			if (val < traget) {
//				lower = middle + 1;
//			}else if (val > traget) {
//				high = middle - 1;
//			}else {
//				return middle;
//			}		
//			middle = (lower + high)/2;
//		}
		
		long middle;
		long res;
		while (lower <= high) {
			middle = (lower + high)/2;
			res = str2Num(str, middle);
			if (res < traget) {
				lower = middle + 1;
			}else if (res > traget) {
				high = middle - 1;
			}else {
				return middle;
			}
		}
		return -1;
	}
}