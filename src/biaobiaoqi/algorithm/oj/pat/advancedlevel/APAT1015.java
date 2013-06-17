package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

public class APAT1015 {
	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in);
		int n , d, m;
		while ((n = cin.nextInt()) >= 0) {
			d = cin.nextInt();
			m = getReverseInt(n, d);
			if (isP(n) && isP(m))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
	
	public static boolean isP(int n){
		if (n == 0 || n == 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i*i <= n; i ++){
			if (n%i == 0)
				return false;
		}
		return true;
	}
	
	public static int getReverseInt(int n, int d){
		int m = 0;
		while (n != 0){
			m = m*d + n%d;
			n = n/d;
		}
		return m;
	}
}
