package biaobiaoqi.pat.advancedlevel;

/*It cost me 40 minutes to make it accepted by PATOJ!!
 * Seconde time.
 * */
import java.util.Arrays;
import java.util.Scanner;

public class APAT1003 {
	public static int n, m, from, to;
	public static int[] c = new int[500];
	public static int[][] e = new int[500][500];
	public static boolean[] known = new boolean[500];
	public static int[] dist = new int[500];
	
	public static int[] cnt = new int[500];
	public static int[] tms = new int[500];

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		from = cin.nextInt();
		to = cin.nextInt();
		for (int i = 0; i < n; i++) {
			c[i] = cin.nextInt();
		}
		int f = 0, t= 0;

		for (int i = 0; i < m; i++) {
			f = cin.nextInt();
			t = cin.nextInt();
			e[f][t] = e[t][f] = cin.nextInt();
		}
		//System.out.println(Arrays.toString(e));
		dijsktra(from, to);
		
		System.out.print(cnt[to] + " " + tms[to]);
	}

	public static void dijsktra(int from, int to) {	
		Arrays.fill(known, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[from] = 0;
		tms[from] = c[from];
		cnt[from] = 1;
		
		while(true){
			//1.find nearest vertex, mark known
			int p = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (!known[i]) {
					if (dist[i] < min) {
						p = i;
						min = dist[i];
					}
				}
			}
			if (p == -1) {
				break;
			}
			known[p] = true;
			
			//2.update dist of unknown vertexes
			for (int j = 0; j < n; j++) {
				if (e[p][j] != 0 && !known[j]) {
					if (dist[j] > dist[p] + e[p][j]) { //Wrong:dist[j] > dist[p] + e[p][j]
						dist[j] = dist[p] + e[p][j];
						cnt[j] = cnt[p];
						tms[j] = tms[p] + c[j];
					}else if (dist[j] == dist[p] + e[p][j]) {
						cnt[j] += cnt[p];//Wrong: cnt[j] = cnt[p] + 1; And it's hard to debug.
						tms[j] = (tms[p] + c[j] > tms[j]) ?tms[p] + c[j] : tms[j]; 
					}	
				}
			}
		}
	}
}
