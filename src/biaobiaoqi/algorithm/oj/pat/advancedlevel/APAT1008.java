package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/**
 * http://pat.zju.edu.cn/contests/pat-a-practise/1008
 * Ë®Ìâ
 * 
 * @author biaobiaoqi
 *
 */
public class APAT1008 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int sum = 0;
		int pos = 0;
		int dest = 0;
		
		for (int i = 0; i < n; i ++) {
			dest = cin.nextInt();
			int tmp = dest - pos;
			sum += (tmp > 0 ? tmp*6 : -tmp*4) + 5;
			
			pos = dest;
		}
		
		System.out.println(sum);

	}
}
