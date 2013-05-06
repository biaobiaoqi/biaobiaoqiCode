package biaobiaoqi.practice.hdoj;

import java.util.Scanner;

public class HDOJ2203 {
	public static int[] next = new int[100005];
	
	public static void main (String[] atgs) {
		Scanner cin = new Scanner(System.in);
		String str = null;
		String dest= null;
		while ((str = cin.next()) != null) {
			dest = cin.next();
			str = str + str;
			kmpNext(dest);
			if (kmp(str, dest)) 
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

	public static void kmpNext(String str) {
		next[0] = 0;
		for(int i = 1, j = 0; i < str.length(); ++ i){
			while (j > 0 && str.charAt(i) != str.charAt(j)) 
				j = next[j - 1];
			if (str.charAt(i) == str.charAt(j)) 
				++ j;
			next[i] = j;
		}
	}
	
	public static boolean kmp(String str, String dest) {
		for (int i = 0, j = 0; i != str.length(); ) {
			if (str.charAt(i) == dest.charAt(j)) {
				++ j;  ++ i;
				if (j == dest.length())
					return true;
			}else if (j == 0){
				++ i;
			}else 
				j = next[j];
				
		}
		return false;
	}
}
