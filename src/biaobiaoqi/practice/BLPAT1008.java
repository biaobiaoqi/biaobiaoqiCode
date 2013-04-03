package biaobiaoqi.practice;

import java.util.Scanner;
/**
 * ���ܻ�ϰ���Ե���������洢�¶������ݣ�����������
 * �������뷨��ֱ�Ӱ������ź��λ�����������ݡ�
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
