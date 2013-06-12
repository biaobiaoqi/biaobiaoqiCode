package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;

/**
 * 
 * �����Ƕ��� dn Ϊ��dn = pn+1 - pn������ pi �ǵ�i����������Ȼ�� d1=1 �Ҷ���n>1�� dn ��ż�����������Բ��롱��Ϊ�����������������Ҳ�Ϊ2����������

�ָ�������������N (< 105)������㲻����N���������������Եĸ�����

�����ʽ��ÿ�������������1����������������������N��

�����ʽ��ÿ���������������ռһ�У�������N���������������Եĸ�����

����������
20
���������
4



 * 1.�����㷨��http://www.cnblogs.com/luluping/archive/2010/03/03/1677552.html
 * 2.<=�ı߽�ֵ
 * 
 * @author biaobiaoqi
 *
 */
public class BLPAT1007 {
	public static Integer[] primes = new Integer[100000];
	public static int index = 0;
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		int count = 0;
		
		primes[index++] = 2;
		for (int i = 3 ; i <= n ; i ++) {
			if (isPrime(i)) {
				//test
				System.out.print(i + " ");
				
				if (primes[index - 1] - primes[index - 2] == 2) {
					count ++;
				}
			}
		}
			
		System.out.println(count);
		
	}
	
	
	public static boolean isPrime(int n) {
		int j;
		boolean result;
		for (j = 0; j < index && primes[j] * primes[j] <= n ; j ++) {
			if (n%primes[j] == 0) {
				break;
			}
		}
		
		if (j >= index || primes[j] * primes[j] > n) {
			primes[index ++] = n;
			result = true;
		}else {
			result = false;
		}
		
		return result;

	}
}
