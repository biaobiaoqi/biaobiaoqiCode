package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;

/**
 * ��ƺ�����һԪ����ʽ�ĵ�����

�����ʽ����ָ���ݽ���ʽ�������ʽ������ϵ����ָ��������ֵ��Ϊ������1000�������������ּ��Կո�ָ���

�����ʽ������������ͬ�ĸ�ʽ�����������ʽ�������ϵ����ָ�������ּ��Կո�ָ�������β�����ж���ո�

����������
3 4 -5 2 6 1 -2 0
���������
12 3 -10 1 6 0


 * ��Ŀ�Բ��Ͻ�������������Ϊ��ʱ�����0 0
 * @author biaobiaoqi
 *
 */
public class BLPAT1010 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int aPre = 0, bPre = 0;
		boolean start = true;
		
		
		while (cin.hasNextInt())
        {	
			aPre = cin.nextInt();
			bPre = cin.nextInt();
			
			aPre *= bPre;
			bPre --;
			
			if (aPre == 0) {
				continue;
			}else {
				if (start) {
					start = false;
				}else {
					System.out.print(" ");
				}
				System.out.print(aPre + " " + bPre);
			}
        }
		
		if (start) {
			System.out.print("0 0");
		}


	}
}
