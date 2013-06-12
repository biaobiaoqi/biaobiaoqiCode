package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/*
 * 1.DFSɨ�����нڵ㡣
 * 2.�����ܽڵ����100����������101*101�ı����洢parent-child��Ӧ��ϵ���ɡ�
 * 3.t[i][0]������ĳ���ڵ��Ƿ���child����ʡ��֮������ļ�������t[0][i]��¼���յ�i���Ҷ�ӽڵ�����
 * 4.��һ��wa��ԭ���ǣ�û�м�¼maxlevel��forѭ������ֹ���˵�n�㣬��ζ�ź�����źܶ�0��
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
