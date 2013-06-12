package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

/*
 * ˮ�⡣
 * д��ʱ���ڸ����Ӷ���С����������һ·û��˼������caseͨ�������������֣����ڼ���n1��n2��ʱ��һЩ����ֵ�趨���ˡ�����
 * 
 * ���⣬������ȫ���Բ�ʹ��ѭ���Ƚϼ����С����Ȼ��������ʽ�ˣ���ʵ����ֱ���Ƶ���n1�ļ�����ʽ��
 * */
public class APAT1031 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		int n = str.length();
		int n1 = 0, n2 = 0;
		
		//calculate
		int max = 1;

		for (int i = 1; i <= n; i ++) {
			if (i > max && 3*i <= n + 2) {
				max = i;
			}
		}
		
		n1 = max; 
		n2 = n + 2 - 2*max;
		
		
//		n1 = (n + 2)/3;
//		n2 = n + 2 - 2*n1;

		
		
		for (int i = 0; i < n1 - 1; i++) {
				System.out.print(str.charAt(i));
				for(int j = 1; j < n2 - 1; j ++) {
					System.out.print(" ");
				}
				System.out.println(str.charAt(n - i -1));
		}
	
		
		for (int i = 0; i != n2; i ++) {
			System.out.print(str.charAt(n1 + i - 1));
		}
	}
}
