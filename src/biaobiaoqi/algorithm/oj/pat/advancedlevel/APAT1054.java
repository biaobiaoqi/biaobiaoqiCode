package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.HashMap;
import java.util.Scanner;

public class APAT1054 {
	public static HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int m = cin.nextInt();
		int n = cin.nextInt();
		int count = m*n;
		int color;
		for (int i = 0; i != count; i++){
			color = cin.nextInt();
			if (hash.containsKey(color))
				hash.put(color, hash.get(color)+ 1);
			else {
				hash.put(color, 1);
			}
		}
		
		count /= 2;
		for (int i : hash.keySet()) {
			if (hash.get(i) > count)
				System.out.println(i);
		}
		
	}
}
