package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;
/*
	Given a non-negative integer N, your task is to compute the sum of all the digits of N, and output every digit of the sum in English.
	
	Input Specification:
	
	Each input file contains one test case. Each case occupies one line which contains an N (<= 10100).
	
	Output Specification:
	
	For each test case, output in one line the digits of the sum in English words. There must be one space between two consecutive words, but no extra space at the end of a line.
	
	Sample Input:
	12345
	Sample Output:
	one five
 * */

/**
 * ˮ��
 * 1.ע��Java ���������ԣ�int��תString�ȡ������Ͳ����Լ������߶�int�ı�����˳�������λ�ˡ�
 * 2.hash��˼�롣
 * 
 * @author biaobiaoqi
 *
 */
public class APAT1005 {
	public static String[] mapArray = {"zero", "one", "two", "three", "four", "five", "six", "seven", 
		"eight", "nine"};
	
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		String str = sin.next();
		char ch;
		int sum = 0;
		for (int i = 0; i != str.length(); i ++) {
			ch = str.charAt(i);
			sum += ch - '0';
		}
		
		str = ((Integer)sum).toString();
		for (int i = 0; i != str.length(); i ++ ) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(mapArray[str.charAt(i) - '0']);
		}
		
		
	}
}
