package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;

/**
 * 《编程珠玑》P73有详细的讲解。
 * 1.简单的使用循环会超时，使用DP会超内存限制
 * 2.其实不用套用DP。可以根据其计算特点，近似的套用零时变量存储中间值，减少计算过程。
 * 3.可以用分治方法解决，当时想到了大致如何分治，但是由于之前考虑这个题的考点是DP，所以没有继续深入思考下去。
 * 4.最优的算法竟然是遍历。看到答案代码后，还是很疑惑，直到看了《珠玑》上的讲解。过程简单，但是理论基础的证明是很严谨巧妙的！也用到了【分治思想】。
 * @author biaobiaoqi
 */

public class APAT1007 {
	public static int[] a = new int[10010];

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();

		for (int i = 0; i < n ; i++) {
			a[i] = cin.nextInt();
		}
		
		int maxfront = 0;
		int maxtear = 0;
		int max = -1;
		int sum = -1;
		int tear = 0;
		int front = 0;
		
		for (int i = 0; i != n; i ++) {
			if (sum < 0) {
				sum = a[i];
				front = i;
				tear= i;
			}else {
				sum += a[i];
				tear = i;
			}
			
			if (sum > max) {
				max = sum;
				maxfront = front;
				maxtear = tear;
			}
		}
		
		if (max < 0) {
			System.out.println("0 " + a[0] + " " + a[n-1]);
		}else {
			System.out.println(max + " " + a[maxfront] + " " +a[maxtear]);	
		}
	}
}
