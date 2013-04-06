package biaobiaoqi.pat.advancedlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * 测试用例还有2,5没有成功.
 * @author biaobiaoqi
 *
 */
public class APAT1003 {
	public static Map<Integer, Vertex> cities = new HashMap<Integer, Vertex>();
	public static int[] cnt = new int[500];
	public static int[] num = new int[500];
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int s = cin.nextInt();
		int d = cin.nextInt();
		
		Vertex v;
		for (int i = 0; i < n ; i++ ) {
			cities.put(i, new Vertex(i, cin.nextInt()));
		}
		int from, to, weight;
		for (int i = 0; i < m; i++) {
			from = cin.nextInt();
			to = cin.nextInt();
			weight = cin.nextInt();
			
			cities.get(from).addAdjacent(new Road(to, weight));
		}
		md(s, d);
		System.out.print(cnt[d] + " " + num[d]);
	}
	
	public static void md(int start, int end) {
		cnt[start] = 1;
		num[start] = cities.get(start).teams;
		cities.get(start).dist = 0;
		
		while(true) {
			int minDist = Integer.MAX_VALUE;
			Vertex minVertex = null;
			for (Entry<Integer, Vertex> entry : cities.entrySet()) {
				Vertex v = entry.getValue();
				if (!v.known && v.dist < minDist) {
					minDist = v.dist;
					minVertex = v;
				}
			}

			if (minVertex == null) {
				break;
			}		
			minVertex.known = true;
			
			for (Road r : minVertex.adj) {
				Vertex newVertex = cities.get(r.dest);
				if(!newVertex.known) {
					if (minVertex.dist + r.weight < newVertex.dist) {
						newVertex.dist = minVertex.dist + r.weight;
						num[newVertex.id] = num[minVertex.id] + newVertex.teams;
						cnt[newVertex.id] = cnt[minVertex.id];
					}else if (minVertex.dist + r.weight == newVertex.dist) {
						if (num[newVertex.id] < num[minVertex.id] + newVertex.teams) {
							num[newVertex.id] = num[minVertex.id] + newVertex.teams;
						}
						cnt[newVertex.id] += cnt[minVertex.id];
					}
				}
			}
		}
	}
	
	public static class Vertex {
		public int id;
		public boolean known;
		public Integer dist;
		public int teams;
		public List<Road> adj; 
		
		public Vertex(int id, int t) {
			this.id = id;
			teams = t;
			dist = Integer.MAX_VALUE;
			known = false;
			adj = new ArrayList<Road>();
		}
		
		public void addAdjacent(Road r) {
			adj.add(r);
		}
	}
	
	public static class Road {
		public int dest;
		public int weight;
		
		public Road (int d, int w) {
			dest = d;
			weight = w;
		}
	}
}