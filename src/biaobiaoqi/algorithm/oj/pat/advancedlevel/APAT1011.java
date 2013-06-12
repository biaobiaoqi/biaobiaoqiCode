package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.math.BigDecimal;
import java.util.Scanner;
/*
	 With the 2010 FIFA World Cup running, football fans the world over were becoming increasingly excited as the best players from the best teams doing battles for the World Cup trophy in South Africa. Similarly, football betting fans were putting their money where their mouths were, by laying all manner of World Cup bets.
	
	Chinese Football Lottery provided a "Triple Winning" game. The rule of winning was simple: first select any three of the games. Then for each selected game, bet on one of the three possible results -- namely W for win, T for tie, and L for lose. There was an odd assigned to each result. The winner's odd would be the product of the three odds times 65%.
	
	For example, 3 games' odds are given as the following:
	
	 W    T    L
	1.1  2.5  1.7
	1.2  3.0  1.6
	4.1  1.2  1.1
	To obtain the maximum profit, one must buy W for the 3rd game, T for the 2nd game, and T for the 1st game. If each bet takes 2 yuans, then the maximum profit would be (4.1*3.0*2.5*65%-1)*2 = 37.98 yuans (accurate up to 2 decimal places).
	
	Input
	
	Each input file contains one test case. Each case contains the betting information of 3 games. Each game occupies a line with three distinct odds corresponding to W, T and L.
	
	Output
	
	For each test case, print in one line the best bet of each game, and the maximum profit accurate up to 2 decimal places. The characters and the number must be separated by one space.
		
	Sample Input
	1.1 2.5 1.7
	1.2 3.0 1.6
	4.1 1.2 1.1
	Sample Output
T T W 37.98
 
 */

/**
 * 1.TODO 或许能用 DP 节省时间。
 * 
 * @author biaobiaoqi
 *
 */
public class APAT1011 {
	public static void main(String args[]) {
		
		String[] array = {"W", "T", "L"};
		
		float[][] odds = new  float[3][3];
		Scanner cin = new Scanner(System.in);
		for (int i = 0; i != 3; i ++) {
			for (int j = 0; j != 3; j ++) {
				odds[i][j] = cin.nextFloat();
			}
		}
		
		float result = 0;
		int[] resultArray = new int[3];
		
		for (int i = 0; i != 3; i ++) {
			for (int j = 0; j != 3; j ++) {
				for (int k = 0; k != 3; k ++) {
					float tmp = (float) ((odds[0][i] * odds[1][j] * odds[2][k] * 0.65 -1)*2.0);
					if (tmp > result) { //maybe there is no same case?
						resultArray[0] = i;
						resultArray[1] = j;
						resultArray[2] = k;
						result = tmp;
					}
				}
			}
		}
		
		//TODO 为什么能AC，但是自己本机上却无法四舍五入。
		BigDecimal b = new BigDecimal(result);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();	
		System.out.println(array[resultArray[0]] + " " 
					+ array[resultArray[1]] + " " 
					+ array[resultArray[2]] + " "
					+ f);
	}
}
