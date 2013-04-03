package biaobiaoqi.practice;

import java.util.Scanner;

/**
 * 这个题目毫无技术含量。
 * @author biaobiaoqi
 *
 */
public class BLPAT1004 {
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		String highestName = null, highestNo = null;
		String lowestName = null, lowestNo = null;
		int highestScore = 0, lowestScore = 100, score;
		String name, no;
		for (int i = 0 ; i < n ; i ++) {
			name = cin.next();
			no = cin.next();
			score = cin.nextInt();
			if (score < lowestScore) {
				lowestScore = score;
				lowestName = name;
				lowestNo = no;
			}
			
			if (score > highestScore) {
				highestName = name;
				highestNo = no;
				highestScore = score;
			}
		}	

		System.out.println(highestName + " " + highestNo);
		System.out.println(lowestName + " " + lowestNo);
	}
}
