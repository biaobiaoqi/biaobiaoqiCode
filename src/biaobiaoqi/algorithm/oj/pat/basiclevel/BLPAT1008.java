package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;
/**
 * 
 * һ������A�д���N��N>0�����������ڲ�����ʹ�����������ǰ���£���ÿ������ѭ��������M��M>=0����λ�ã�����A�е������ɣ�A0 A1����AN-1���任Ϊ��AN-M ���� AN-1 A0 A1����AN-M-1�������M����ѭ��������ǰ���M��λ�ã��������Ҫ���ǳ����ƶ����ݵĴ��������٣�Ҫ�������ƶ��ķ�����

�����ʽ��ÿ���������һ��������������1������N ( 1<=N<=100)��M��M>=0������2������N��������֮���ÿո�ָ���

�����ʽ����һ�������ѭ������Mλ�Ժ���������У�֮���ÿո�ָ������н�β�����ж���ո�

����������
6 2
1 2 3 4 5 6
���������
5 6 1 2 3 4



 * 
 * 1.�����뷨��ֱ�Ӱ������ź��λ�����������ݡ�
 * 
 * @author biaobiaoqi
 *
 */
public class BLPAT1008 {
	public static void main(String args[]) {
		
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		int offset = cin.nextInt();
		offset = offset % count;
		
		Integer[] array = new Integer[1000];
		
		
		/*
		 * 0,1,2, 3,4 (5,2)
		 * 3,4, 0,1,2
		 * 
		 * */
		for (int i = 0 ; i != count; i ++) {
			int tmp = cin.nextInt();
			
			if (i < count - offset) {
				array[i + offset] = tmp;
			}else {
				array[i - count + offset] = tmp;
			}
		}	
		
		for (int i = 0; i != count; i ++) {
			System.out.print(array[i]);
			if (i != count -1) {
				System.out.print(" ");
			}

			
		}
	}
}
