package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/**
 * http://pat.zju.edu.cn/contests/pat-a-practise/1003
 * 对于需要一些变形的算法，先打出基本算法。然后再改进，否则容易弄混。
 * @author biaobiaoqi
 */
public class APAT1003 {
	public static int n, m, from, to;
	public static final int max = 500;
	public static int[] c = new int[max];
	public static boolean[] known = new boolean[max];
	public static int[] dist = new int[max];
	public static int[][] e = new int[max][max];
	
	public static int[] cnt = new int[max];
	public static int[] tms = new int[max];
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		from = cin.nextInt();
		to = cin.nextInt();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(known, false);
		for (int i = 0; i < n; i++) {
			Arrays.fill(e[0], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < n; i++) {
			c[i] = cin.nextInt();
		}
		
		int f = 0, t= 0, w = 0;
		for (int i = 0; i < m; i++) {
			f = cin.nextInt();
			t = cin.nextInt();
			w = cin.nextInt();
			e[f][t] = e[t][f] = w;
			//TODO else e can be Integer.MAX_VALUE?
		}
		
		dijkstra(from, to);
		System.out.println(cnt[to] + " " + tms[to]);
		
	}
	
	public static void dijkstra(int from, int to) {
		dist[from] = 0;
		cnt[from] = 1;
		tms[from] = c[from];
		
		while(true) {
			//1.find min in unkown, mark known
			int p = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (!known[i] && dist[i] < min) {
					min = dist[i];
					p = i;
				}
			}
			if (p == -1) {
				break;
			}
			known[p] = true;
			
			//2.update dist in unknown
			for(int j = 0; j < n; j++) {
				if (!known[j] && e[p][j] != 0) {
					if (dist[j] > dist[p] + e[p][j]) {
						dist[j] = dist[p] + e[p][j];
						cnt[j] = cnt[p];
						tms[j] = tms[p] + c[j];
					}else if (dist[j] == dist[p] + e[p][j]) {
						cnt[j] += cnt[p];
						tms[j] = (tms[p] + c[j] > tms[j])?tms[p] + c[j] : tms[j];
					}
				}
			}
		}
	}
}
