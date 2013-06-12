package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/*
	People in Mars represent the colors in their computers in a similar way as the Earth people. That is, a color is represented by a 6-digit number, where the first 2 digits are for Red, the middle 2 digits for Green, and the last 2 digits for Blue. The only difference is that they use radix 13 (0-9 and A-C) instead of 16. Now given a color in three decimal numbers (each between 0 and 168), you are supposed to output their Mars RGB values.
	
	Input
	
	Each input file contains one test case which occupies a line containing the three decimal color values.
	
	Output
	
	For each test case you should output the Mars RGB value in the following format: first output "#", then followed by a 6-digit number where all the English characters must be upper-cased. If a single color is only 1-digit long, you must print a "0" to the left.
	
	Sample Input
	15 43 71
	Sample Output
	#123456
 * */

/**
 * 水题，Hash实现
 * @author biaobiaoqi
 *
 */
public class APAT1027 {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		String str1 = transfer(a);
		String str2 = transfer(b);
		String str3 = transfer(c);
		
		System.out.print("#" + str1 + str2 + str3);		
	}
	
	public static char[] trans = {'0','1','2','3','4','5','6','7','8','9','A','B','C'}; 
	
	public static String transfer(int a) {
		return (""+ trans[a/13] + trans[a%13]);
	}

}
