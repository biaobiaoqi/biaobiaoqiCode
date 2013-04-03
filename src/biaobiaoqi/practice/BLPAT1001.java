package biaobiaoqi.practice;

import java.util.Scanner;
/**
 * 提交的时候一直【返回非零】，只要去掉package信息，就没问题了。
 * @author biaobiaoqi
 *
 */
public class BLPAT1001 {
	public static int ThreeNPlus1 (int n) {
		int count = 0;
		while (n != 1) {
			count ++ ;
			if (n%2 == 0) {
				n/= 2;
			}else {
				n = (3*n + 1)/2;
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		int n = 0;
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNextInt())
        {
			n = cin.nextInt();
			System.out.println(ThreeNPlus1(n));
        }

	}
	
}
