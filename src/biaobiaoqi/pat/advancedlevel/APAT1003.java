package biaobiaoqi.pat.advancedlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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
		
		//TODO
		cnt[s] = 1;
		num[s] = cities.get(s).teams;
		
		md(s, d);
		
		//TODO
		System.out.print(cnt[d] + " " + num[d]);
		
		
		//dfs(0, cities.get(d));
		//System.out.print(allWays + " " + maxTeams);
	}
	
	public static void md(int start, int end) {
		cities.get(start).dist = 0;
		while(true) {
			//find shortest one in unknow vertexes.
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
					//< may lose some cases
//					if (minVertex.dist + r.weight <= newVertex.dist) {
//						newVertex.dist = minVertex.dist + r.weight;
//						newVertex.lastPath.add(minVertex);						
//					}
					
					//TODO
					if (minVertex.dist + r.weight < newVertex.dist) {
						newVertex.dist = minVertex.dist + r.weight;
						newVertex.lastPath.add(minVertex);	
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
	
	public static int maxTeams = 0;
	public static int allWays = 0;
	
	//TODO it's not necessary to keep all values in list.
	//Just the max is ok, and all values will be psed by parameters.
	public static void dfs(int currentTeams, Vertex v) {
		currentTeams += v.teams;
		if (currentTeams > maxTeams) {
			maxTeams = currentTeams;
		}
		
		if(v.lastPath.size() == 0) {
			allWays ++;
			return;
		}else {
			for (int i = 0; i != v.lastPath.size(); i ++) {
				if (i == 0) {
					dfs(currentTeams, v.lastPath.get(0));
				}else {
					dfs(currentTeams, v.lastPath.get(i));
				}
			}
		}
	}
	
	public static class Vertex {
		public int id;
		public boolean known;
		public Integer dist;
		public int teams;
		public List<Vertex> lastPath;
		
		public List<Road> adj; //TODO array[][]?
		
		public Vertex(int id, int t) {
			this.id = id;
			teams = t;
			lastPath = new ArrayList<Vertex>();
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
