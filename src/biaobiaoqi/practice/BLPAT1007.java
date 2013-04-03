package biaobiaoqi.practice;

import java.util.Scanner;

/**
 * Àÿ ˝À„∑®£∫http://www.cnblogs.com/luluping/archive/2010/03/03/1677552.html
 * 
 * @author biaobiaoqi
 *
 */
public class BLPAT1007 {
	public static Integer[] primes = new Integer[100000];
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int index = 0;
		primes[index++] = 2;
		
		for (int i = 3 ; i < n ; i ++) {
			int j;
			for (j = 0; primes[j] * primes[j] < n || j < index; j ++) {
				if (n%primes[j] == 0) {
					break;
				}
				
				if (j >= primes[j] * primes[j]) {
					primes[index ++] = n;
				}
			}
		}
		
		for (int i = 0; i < index; i++) {
			System.out.print(primes[i] + " ");
		}
	}
}
