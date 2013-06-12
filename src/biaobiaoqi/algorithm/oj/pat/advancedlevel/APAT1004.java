package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/*
 * 1.DFS扫描所有节点。
 * 2.由于总节点最多100个，于是用101*101的表来存储parent-child对应关系即可。
 * 3.t[i][0]代表了某个节点是否有child，节省了之后运算的计算量。t[0][i]记录最终第i层的叶子节点数。
 * 4.第一次wa的原因是：没有记录maxlevel。for循环的终止到了第n层，意味着后面跟着很多0！
 * */
public class APAT1004 {
	public static final int max = 101;
	public static int[][] t = new int[max][max];
	public static int n, m;
	public static int maxLevel = 0;
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		
		for (int i = 0; i < m; i++) {
			int parent = cin.nextInt();
			int num = cin.nextInt();
			t[parent][0] = 1;
			for (int j = 1; j <= num; j ++) {
				int child = cin.nextInt();
				t[parent][child] = 1;
			}
		}
		
		dfs(1, 1);
		
		boolean start = true;
		for (int i = 1; i <= maxLevel; i ++) {
			if (start) {
				System.out.print(t[0][i]);
				start = false;
			}else {
				System.out.print(" " + t[0][i]);					
			}
		}
	}

	public static void dfs(int parent, int level){
		if (level > maxLevel) {
			maxLevel = level;
		}
		if (t[parent][0] == 0) {
			t[0][level] ++;
		}else {
			for (int i = 1; i <= n; i ++) {
				if (t[parent][i] != 0) {
					dfs(i, level + 1);					
				}
			}
		}
	}
}
