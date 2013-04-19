package biaobiaoqi.algorithm.tool;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;


public class Playground {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int citynum = scanner.nextInt();
		int roadnum = scanner.nextInt();
		int startcity = scanner.nextInt();
		int endcity = scanner.nextInt();
		
		
		int[][] adj = new int[citynum][citynum];
		
		int[] resnum = new int[citynum];
		boolean[] isVisited = new boolean[citynum];
		
		int[] distTo = new int[citynum];
		int[] res = new int[citynum];
		int[] count = new int[citynum];
		
		
		
		for(int i=0; i<citynum; i++){
			for(int j = 0; j<citynum; j++){
				adj[i][j] = 1000000;
			}
			adj[i][i] = 0; 
			res[i] = 0;
			isVisited[i] = false;
			count[i] = 0;
			resnum[i] = scanner.nextInt();
		}
		
		
		for(int i=0; i<citynum; i++){
			distTo[i] = 1000000;
		}
		
		distTo[startcity] = 0;
		
		res[startcity] = resnum[startcity];

		for(int i=0; i<roadnum; i++){
			int c1 = scanner.nextInt();
			int c2 = scanner.nextInt();
			int length = scanner.nextInt();
			adj[c1][c2] = adj[c2][c1] = length;
		}
		
		if(startcity == endcity){
			System.out.println(1+" "+resnum[startcity]);
			return;
		}
		
		while(isEmpty(isVisited,distTo)){
			int s = getMin(isVisited,distTo);
			isVisited[s] = true;
			for(int i=0; i<citynum; i++){
				if(adj[s][i]!=1000000&&s!=i)
					if(distTo[i]>=distTo[s]+adj[s][i]){
						count[i]++;
						if(distTo[i]==distTo[s]+adj[s][i]){
							if(res[i] <= res[s]+resnum[i]){
								res[i] = res[s]+resnum[i];
							}
						}else{
							res[i] = res[s]+resnum[i];
						}
						distTo[i]=distTo[s]+adj[s][i];
					}
			}
		}
		
		System.out.println(count[endcity]+" "+res[endcity]);
		
	}
	
	static boolean isEmpty(boolean[] isVisited,int[] distTo){
		boolean flag = false;
		for(int i = 0; i<isVisited.length;i++){
			if(!isVisited[i]&&distTo[i]!=1000000){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	static int getMin(boolean[] isVisited, int[] distTo){
		int min = 1000000;
		int m = -1;
		
		for(int i = 0; i<isVisited.length;i++){
			if(!isVisited[i]&&distTo[i]!=1000000)
				if(min>distTo[i]){
					m = i;
					min = distTo[i];
				}
		}
		return m;
	}
}

class Node{
	int start;
	int end;
	int length;
	
	public Node(int s, int e, int l){
		this.start = s;
		this.end = e;
		this.length = l;
	}
}
