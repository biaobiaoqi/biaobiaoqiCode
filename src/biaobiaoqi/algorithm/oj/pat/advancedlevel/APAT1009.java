package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * http://pat.zju.edu.cn/contests/pat-a-practise/1009
 * 1.类似于桶排序的思想。用空间换取时间。
 * 2.第一次提交错误的原因是：算错了最终桶的大小。几个概念换来换去，容易换错。
 * @author biaobiaoqi
 *
 */

public class APAT1009 {
	public static final int resultLength = 1000010;
	
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		
		float[] p1 = new float[30];
		float[] p2 = new float[30];
		float[] pr = new float[resultLength];
		int e; //exponent
		float c; //coefficient
		
		//input
		int n1 = sin.nextInt();
		readArray(n1, p1, sin);
		
		int n2 = sin.nextInt();
		readArray(n2, p2, sin);
		
		
		//clear result array
		int i;
		for(i = 0; i != resultLength; i += 1) {
			pr[i] = 0;
		}
		
		for( i = 0; i != n1; i ++) {
			for ( int j = 0; j != n2; j ++) {
				e = (int) (p1[i*2] + p2[j*2]);
				c = p1[i*2 + 1]*p2[j*2 + 1];
				
				pr[e] += c;
			}
		}
		
		int count = 0;
		for (i = 0; i != resultLength; i ++) {
			if (pr[i] != 0) {
				count ++;
			}
		}
		
		System.out.print(count);
		
		for (i = resultLength -1; i >= 0; i --) {
			if (pr[i] != 0) {
				BigDecimal big = new BigDecimal(pr[i]);
				float f = big.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
				
				System.out.print(" " + i + " " + f);
			}
		}
	}
	
	public static void readArray(int n, float[] fArray, Scanner sin) {
		int i = 0; 
		while (i < n) {
			int e = sin.nextInt();
			float c = sin.nextFloat();
			
			fArray[i*2] = e;
			fArray[i*2 + 1] = c;
			
			i ++;
		}
	}
}
