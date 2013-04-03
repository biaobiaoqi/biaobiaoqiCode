package biaobiaoqi.practice;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class BLPAT1005 {
	public static void main(String args[]) {
		int n = 0;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int num;
		
		while (n > 0) {
			n --;
			num = cin.nextInt();
			
			//
			while (num != 1) {
				if (isIn(num)) {
					
				}else {
					putIn(num);
				}
			}
		}
	}
	
	public static boolean isIn(int n) {
		return false;
	}
	
	public static void putIn(int n) {
		
	}

}
