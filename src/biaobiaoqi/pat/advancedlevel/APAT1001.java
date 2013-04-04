package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;
/**
 * 
	Calculate a + b and output the sum in standard format -- that is, the digits must be separated into groups of three by commas (unless there are less than four digits).
	
	Input
	
	Each input file contains one test case. Each case contains a pair of integers a and b where -1000000 <= a, b <= 1000000. The numbers are separated by a space.
	
	Output
	
	For each test case, you should output the sum of a and b in one line. The sum must be written in the standard format.
	
	Sample Input
	-1000000 9
	Sample Output
	-999,991
 * 
 * 
 * 1.д����ǰ��������ֵ�˼�����������������ÿ�����֮��Ĺ�ϵ���ҳ���ͬ���֣������߼���
 * 2.ʵ���ϣ�Javaֻ��Ҫʹ��NumberFormat����ֱ��ת����
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
