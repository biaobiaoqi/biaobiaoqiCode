package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/**
 * It will timeout using Java.
 * The working code is in APAT1048.cpp.
 * @author biaobiaoqi
 *
 */
public class APAT1048 {
	public static int max = 100005;
	public static int[] a = new int[max];
	public static void main(String[] atgs){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int min = max;
		int tmpMin, tmp;
		for (int i =0; i != n; i ++) {
			tmp = cin.nextInt();
			if (tmp < m) {
				tmpMin = tmp < m - tmp? tmp : m - tmp;
				if (a[m - tmp] != 0 && tmpMin < min) {
					min = tmpMin;
				}
				a[tmp] = 1;				
			}
		}
		
		if (min < max) {
			System.out.println(min + " " + (m - min));
		}else {
			System.out.println("No Solution");
		}
	}
}
