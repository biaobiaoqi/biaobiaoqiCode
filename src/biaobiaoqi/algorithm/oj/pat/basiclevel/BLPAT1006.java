package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;

/**
 * 
 * ����������ĸB����ʾ���١�����ĸS��ʾ��ʮ�����á�12...n������ʾ��λ����n��<10����������ʽ�������һ��������3λ��������������234Ӧ�ñ����ΪBBSSS1234����Ϊ����2�����١���3����ʮ�����Լ���λ��4��

�����ʽ��ÿ�������������1����������������������n��<1000����

�����ʽ��ÿ���������������ռһ�У��ù涨�ĸ�ʽ���n��

��������1��
234
�������1��
BBSSS1234
��������2��
23
�������2��
SS123


 * @author biaobiaoqi
 *
 */
public class BLPAT1006 {
	public static void main(String args[]) {
		int n = 0;
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNextInt())
        {
			n = cin.nextInt();
			int tmp = n;
			
			tmp /= 100;
			for (int i = 0; i < tmp; i ++) {
				print('B');
			}
			
			n -= tmp * 100;
			tmp = n;
			tmp /= 10;
			for (int i = 0; i < tmp; i ++) {
				print('S');
			}
			
			n -= tmp*10;
			for (int i = 0; i < n; i ++) {
				System.out.print(i+1);
			}
        }
	}
	
	public static void print(char ch) {
		System.out.print(ch);
	}
	
}
