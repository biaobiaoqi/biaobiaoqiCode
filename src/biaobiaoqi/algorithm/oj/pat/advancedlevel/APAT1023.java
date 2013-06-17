package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
//http://pat.zju.edu.cn/contests/pat-a-practise/1023

public class APAT1023 {
	public static String str;
	public static int[] result = new int[20];
	public static int[] digits = new int[10];//1-9
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		str = cin.next();
		
		for(int i = 0; i != str.length(); i ++)
			digits[intValue(i)] ++;
		boolean flag = true;
		int carry = 0;
		for(int i = str.length() - 1; i >= 0; i--){
			result[i] = intValue(i)*2%10 + carry;
			digits[result[i]] --;
			carry = intValue(i)*2/10;
		}
		if (carry != 0 )
			flag = false;
		
		for (int i = 1; i < 10; i ++)
			if (digits[i] != 0)
				flag = false;
		
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		if (carry != 0)
			System.out.print(carry);
		for (int i = 0 ; i != str.length(); i ++)
			System.out.print(result[i]);
		
	}
	
	public static int intValue(int index){
		return str.charAt(index) - '0';
	}
	
}
