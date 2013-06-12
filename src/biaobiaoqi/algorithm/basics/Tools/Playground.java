package biaobiaoqi.algorithm.basics.Tools;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;
//dest:abcabaefabcabc


//dest:abcaba
//str:abcabcaba
public class Playground {
	public static int[] next = new int[100005];
	
	public static void main(String[] args){
		 kmpNext("ABCDABD");
		//TODO It's wrong!
		 if(kmp("ABC ABCDAB ABCDABCDABDE", "ABCDABD"))
			 System.out.println("YES");
		 else 
			 System.out.println("NO");
	}
	

	public static boolean kmp(String str, String dest) {
//		for (int i = 0, j = 0; i != str.length(); ) {
//			if (str.charAt(i) == dest.charAt(j)) {
//				++ j;  ++ i;
//				if (j == dest.length())
//					return true;
//			}else if (j == 0){
//				++ i;
//			}else
//				j = next[j-1];
//		}
//		return false;
		for (int i = 0, j = 0; i < str.length(); i ++) {
			while (j > 0 && str.charAt(i) != dest.charAt(j))
				j = next[j - 1];
			if (str.charAt(i) == dest.charAt(j))
				j ++;
			
			if (j == dest.length())
				return true;
		}
		return false;
	}
	
	public static void kmpNext(String str) {
		next[0] = 0;
		System.out.print("0 ");
		for(int i = 1, j = 0; i < str.length(); ++ i){
			while (j > 0 && str.charAt(i) != str.charAt(j)) 
				j = next[j - 1];//TODO what's the index, j-1 or j?
			if (str.charAt(i) == str.charAt(j)) 
				++ j;
			next[i] = j;
			System.out.print(j + " ");
		}
	}
	
}