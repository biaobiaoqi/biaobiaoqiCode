package biaobiaoqi.practice;

import java.util.Scanner;

public class BLPAT1010 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int aPre = 0, bPre = 0;
		boolean start = true;
		
		
		while (cin.hasNextInt())
        {	
			aPre = cin.nextInt();
			bPre = cin.nextInt();
			
			aPre *= bPre;
			bPre --;
			
			if (aPre == 0) {
				continue;
			}else {
				if (start) {
					start = false;
				}else {
					System.out.print(" ");
				}
				System.out.print(aPre + " " + bPre);
			}
        }

	}
}
