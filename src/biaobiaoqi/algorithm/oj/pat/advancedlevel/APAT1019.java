package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.ArrayList;
import java.util.Scanner;
//why WA?!!!

public class APAT1019 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		long n = cin.nextLong(); 
		long d = cin.nextLong();
		ArrayList<Long> r = getResult(n, d);
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
	
	public static ArrayList<Long> getResult(long n, long d) {
		ArrayList<Long> r = new ArrayList<Long>();
		while (n != 0){
			r.add(n%d);
			n /= d;
		}
		return r;
	}
}
