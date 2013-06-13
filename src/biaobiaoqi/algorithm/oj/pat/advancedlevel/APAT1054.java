package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

public class APAT1054 {
//	public static HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int m = cin.nextInt();
		m = m * cin.nextInt();
		int color;
		int cad = 0;
		int count = 0;
		for (int i = 0; i != m; i++){
			color = cin.nextInt();
			if (count == 0)
				cad  = color;
			else if (cad == color) 
				count ++;
			else 
				count --;
		}

		System.out.println(cad);
		
	}
}
