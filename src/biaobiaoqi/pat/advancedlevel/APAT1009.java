package biaobiaoqi.pat.advancedlevel;

import java.math.BigDecimal;
import java.util.Scanner;
/*
	This time, you are supposed to find A*B where A and B are two polynomials.
	
	Input Specification:
	
	Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial: K N1 aN1 N2 aN2 ... NK aNK, where K is the number of nonzero terms in the polynomial, Ni and aNi (i=1, 2, ..., K) are the exponents and coefficients, respectively. It is given that 1 <= K <= 10, 0 <= NK < ... < N2 < N1 <=1000.
	
	Output Specification:
	
	For each test case you should output the product of A and B in one line, with the same format as the input. Notice that there must be NO extra space at the end of each line. Please be accurate up to 1 decimal place.
	
	Sample Input
	2 1 2.4 0 3.2
	2 2 1.5 1 0.5
	Sample Output
	3 3 3.6 2 6.0 1 1.6
*/

/**
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
