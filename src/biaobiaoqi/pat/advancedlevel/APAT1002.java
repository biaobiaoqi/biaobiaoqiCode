package biaobiaoqi.pat.advancedlevel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
/*
	1002. A+B for Polynomials (25)
	 
	This time, you are supposed to find A+B where A and B are two polynomials.
	
	Input
	
	Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial: K N1 aN1 N2 aN2 ... NK aNK, where K is the number of nonzero terms in the polynomial, Ni and aNi (i=1, 2, ..., K) are the exponents and coefficients, respectively. It is given that 1 <= K <= 10，0 <= NK < ... < N2 < N1 <=1000.
	
	Output
	
	For each test case you should output the sum of A and B in one line, with the same format as the input. Notice that there must be NO extra space at the end of each line. Please be accurate to 1 decimal place.
	
	Sample Input
	2 1 2.4 0 3.2
	2 2 1.5 1 0.5
	Sample Output
	3 2 1.5 1 2.9 0 3.2
 */

/**
 * 1.这道题的循环处理有很多不同的方式，但个人认为将越界判断放到外层，内部实现三种大小比较这种循环模式最简捷，不容易出错。
 * 2.Java的保留小数位数方法：http://blog.csdn.net/yuhua3272004/article/details/3075436
 * 3.Java的浮点数处理要注意。比较浮点数不能直接用==，而是需要取abs后比较eps
 * @author biaobiaoqi
 *
 */
public class APAT1002 {

	public static void main(String args[]) {
		int n = 0;
		ArrayList<Float> aList = new ArrayList<Float>(12);
		ArrayList<Float> bList = new ArrayList<Float>(12);
		ArrayList<Float> cList = new ArrayList<Float>(25);
		
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		for (int i = 0; i < n*2; i++) {
			aList.add(cin.nextFloat());
		}
		n = cin.nextInt();
		for (int i = 0; i < n*2; i++) {
			bList.add(cin.nextFloat());
		}
		
		//the loops are very fragile!
		int i = 0 , j = 0, count = 0;
		while ( i < aList.size() && j < bList.size()) {
			if (aList.get(i) > bList.get(j)) {
				cList.add(aList.get(i));
				cList.add(aList.get(i+1));
				
				i += 2;
				count += 2;
			}
			
			else if (bList.get(j) > aList.get(i)) {
				cList.add(bList.get(j));
				cList.add(bList.get(j + 1));
				
				j += 2;
				count += 2;
			}
			
			//eps
			else if (Math.abs(aList.get(i) - bList.get(j) )<1e-8) {
				if (aList.get(i + 1) + bList.get(j + 1) != 0) {
					cList.add(aList.get(i));
					cList.add(aList.get(i + 1) + bList.get(j + 1));	
					
					count += 2;
				}
				
				i += 2;
				j += 2;
			}
		}
		
		while (i < aList.size()) {
			cList.add(aList.get(i));
			cList.add(aList.get(i+1));
			
			i += 2;
			count += 2;
		}
		
		while (j < bList.size()) {
			cList.add(bList.get(j));
			cList.add(bList.get(j + 1));
			
			j += 2;
			count += 2;
		}

		System.out.print(cList.size()/2);
		for (int in = 0; in != cList.size(); in ++) {
			if (in%2 != 0) {
				//output  accurate 1 decimal place
				BigDecimal b = new BigDecimal(cList.get(in));
				float f = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();				
				System.out.print(" " + f);
			}else {
				System.out.print(" " + cList.get(in).intValue());
			}
		}
	}
	
}
