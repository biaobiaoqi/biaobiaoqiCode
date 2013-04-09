package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;

/**
 * 不能用Java跑。Java的数组效率太慢了。用C实现的即可。
 * 这个方法，用一个数组标记。
 * 另有一种方法更快。两个100001的数组，一个累计输入的次数，一个是输入顺序，是一个hash表。【hash的思想】
 * @author biaobiaoqi
 *
 */
public class APAT1041 {
	
	public static int[] s = new int[10001];
	public static int max = 100001;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = 0;
		for (int i = 1; i <= n; i ++) {
			m = cin.nextInt();
			if (s[m] == 0) {
				s[m] = i;
			}else {
				s[m] = max;
			}
		}
		
		int index = 0;
		for (int i = 1; i < 10001; i++) {
			if (s[i] != 0 && s[i] < max) {
				index = i;
				max = s[i];
			}
		}
		
		if (index == 0) {
			System.out.print("None");
		}else {
			System.out.println(index);
		}
	}
}
