package biaobiaoqi.practice;

import java.util.Scanner;
/**
 * 可能会习惯性的先用数组存储下读入数据，再依次排序。
 * 更简洁的想法是直接按照重排后的位置来插入数据。
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
