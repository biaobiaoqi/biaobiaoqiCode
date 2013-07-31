package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/**
 * http://pat.zju.edu.cn/contests/pat-a-practise/1001
 * 1.写代码前，先做充分的思考。分析各种情况，每种情况之间的关系，找出共同部分，理清逻辑。
 * 2.实质上，Java只需要使用NumberFormat即可直接转换。
 * @author biaobiaoqi
 *
 */

public class APAT1001 {
	public static void main(String args[]) {
		int a = 0, b = 0;
		Scanner cin = new Scanner(System.in);
		
		a = cin.nextInt();
		b = cin.nextInt();
		
		int sum = a + b;
		if (sum < 0) {
			System.out.print("-");
			sum *= -1;
		} 
		
		calculate(sum);
	}
	
	public static void calculate(int n){
		String string = ((Integer)n).toString();
		System.out.print(string.substring(0, string.length()%3));
		for (int i  = string.length()%3; i < string.length(); i += 3) {
			if (i != 0) {
				System.out.print(",");
			}
			
			System.out.print(string.substring(i, i + 3));
		}
	}
}
