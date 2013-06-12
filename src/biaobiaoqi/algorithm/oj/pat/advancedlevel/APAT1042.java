package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/**
 * 水题。hash一下就好。
 * 
 * @author biaobiaoqi
 *
 */
public class APAT1042 {
	public static String[] init = {"", "S1","S2","S3","S4","S5","S6","S7","S8","S9","S10","S11","S12","S13",
		"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13",
		"C1","C2","C3","C4","C5","C6","C7","C8","C9","C10","C11","C12","C13",
		"D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12","D13",
		"J1", "J2"};
	public static String[] result = new String[55];
	public static int[] trans = new int[55];
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		for (int i = 1; i <= 54; i ++) {
			trans[i] = cin.nextInt();
		}
		while (n > 0) {
			n --;
			for (int i = 1; i <= 54; i ++) {
				result[trans[i]] = init[i];
			}
			String[] tmp = result;
			result = init;
			init = tmp;
		}
		
		for (int i =1; i <= 54; i ++) {
			if (i != 1) {
				System.out.print(" ");
			}
			System.out.print(init[i]);
		}
	}
}
