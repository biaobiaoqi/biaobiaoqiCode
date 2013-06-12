package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

/*
 * 水题。
 * 写的时候在跟妹子短信小吵。。。。一路没心思。两个case通不过。后来发现，是在计算n1，n2的时候，一些参数值设定乱了。。。
 * 
 * 另外，这里完全可以不使用循环比较计算大小。既然有两个公式了，其实可以直接推导出n1的计算表达式！
 * */
public class APAT1031 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		int n = str.length();
		int n1 = 0, n2 = 0;
		
		//calculate
		int max = 1;

		for (int i = 1; i <= n; i ++) {
			if (i > max && 3*i <= n + 2) {
				max = i;
			}
		}
		
		n1 = max; 
		n2 = n + 2 - 2*max;
		
		
//		n1 = (n + 2)/3;
//		n2 = n + 2 - 2*n1;

		
		
		for (int i = 0; i < n1 - 1; i++) {
				System.out.print(str.charAt(i));
				for(int j = 1; j < n2 - 1; j ++) {
					System.out.print(" ");
				}
				System.out.println(str.charAt(n - i -1));
		}
	
		
		for (int i = 0; i != n2; i ++) {
			System.out.print(str.charAt(n1 + i - 1));
		}
	}
}
