package biaobiaoqi.practice;

import java.util.Scanner;

public class BLPAT1002 {
	public static String[] array = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
	
	public static void printSum(String str) {
		char ch;
		int sum = 0;
		for (int i = 0; i != str.length(); i ++) {
			ch = str.charAt(i);
			sum += ch - '0';
		}
		
		Integer sumInteger = sum;
		String sumString = sumInteger.toString();

		for (int i = 0 ; i < sumString.length() ; i ++) {
			int index = sumString.charAt(i) - '0';
			if (i == sumString.length() - 1) {
				System.out.print(array[index]);
			}else {
				System.out.print(array[index] + " ");				
			}
		}
	}
		
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);		
		String str = cin.next();
		printSum(str);
	}
}
