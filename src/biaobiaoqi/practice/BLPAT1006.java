package biaobiaoqi.practice;

import java.util.Scanner;

/**
 * 题目太水了，没什么好说的=。=
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
