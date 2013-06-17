package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;


public class APAT1024 {
	public static String str;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		str = cin.next();
		int limit = cin.nextInt();
		
		int steps;
		for (steps = 0; steps < limit; steps ++){
			//check if palindromic,break
			boolean flag = true;
			for (int j = 0, k = str.length() - 1; j < k; j ++, k --)
				if (str.charAt(j) != str.charAt(k)){
					flag = false;
					break;
				}
			if (flag)
				break;
			
			//str --> new str
			StringBuilder sb = new StringBuilder();
			int carry = 0;
			int length = str.length();
			for (int i = length - 1; i >= 0; i --){
				int sum = getInt(i)+getInt(length - i -1) + carry;
				carry = sum/10;
				sb.append(sum%10);
			}
			if(carry != 0)
				sb.append(carry);
			
			str = sb.toString();
		}
		
		//output str and i
		for (int i = str.length() - 1; i >= 0; i --)
			System.out.print(str.charAt(i));
		
		System.out.println();
		System.out.println(steps);
	}
	
	public static int getInt(int i){
		return str.charAt(i) - '0';
	}
}
