package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
//http://pat.zju.edu.cn/contests/pat-a-practise/1040
//time out. cpp format can be accepted.

public class APAT1040 {
 
	
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine();
		int max = 0;
		int length = str.length();
		for (int i = 0; i != str.length(); i ++){
			//'aba', take care the lower limit is 0.
			int j = 0;
			while(i-j >= 0 && i+j < length && str.charAt(i-j) == str.charAt(i+j)){
				if (max < j*2 + 1)
					max = j*2 + 1;
				j ++;
			}
			
			//i as the former 'b' in 'abba'
			j = 1;
			while(i + 1- j >= 0 && i + j < length && str.charAt(i + 1 - j) == str.charAt(i + j)){
				if (max < j*2)
					max = j*2;
				j ++;
			}
		}
		
		System.out.println(max);
	}

	 
}