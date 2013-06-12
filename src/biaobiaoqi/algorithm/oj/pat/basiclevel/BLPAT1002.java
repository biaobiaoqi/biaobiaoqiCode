package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;

/**
 * ����һ����Ȼ��n���������λ����֮�ͣ��ú���ƴ��д���͵�ÿһλ���֡�

�����ʽ��ÿ�������������1��������������������Ȼ��n��ֵ�����ﱣ֤nС��10100��

�����ʽ����һ�������n�ĸ�λ����֮�͵�ÿһλ��ƴ�����ּ���1 �ո񣬵�һ�������һ��ƴ�����ֺ�û�пո�

����������
1234567890987654321123456789
���������
yi san wu

 * @author biaobiaoqi
 *
 */
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
