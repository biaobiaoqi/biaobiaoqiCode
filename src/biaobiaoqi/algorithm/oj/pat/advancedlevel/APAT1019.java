package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.ArrayList;
import java.util.Scanner;
//Take care of 0 case.

public class APAT1019 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(); 
		int d = cin.nextInt();
		ArrayList<Integer> r = getResult(n, d);
		int length = r.size();
		
		//This i,j way is clearer than length/2 - 1.
		int i,j;
		for (i = 0, j = length - 1; i < j; i ++, j --) 
			if (r.get(i) != r.get(j))				
				break;
		
		if (i >= j)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		boolean start = true;
		for (i = length - 1; i >= 0; i --){
			if (start)
				start = false;
			else
				System.out.print(" ");
			
			System.out.print(r.get(i));
		}
	}
	
	public static ArrayList<Integer> getResult(int n, int d) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (n == 0)
			r.add(0);
		
		while (n != 0){
			r.add(n%d);
			n /= d;
		}
		
		return r;
	}
}
