package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

public class APAT1056 {
	 
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int m = cin.nextInt();
		int n = cin.nextInt();
		int[] mice = new int[m];
		int[] order = new int[m];
		int[] rank = new int[m];
		
		for (int i = 0; i != m; i ++) 
			mice[i] = cin.nextInt();
		for (int i = 0; i != m; i ++) 
			order[i] = cin.nextInt();
	
		while (order.length > 1){
			int gamesCount = order.length / n + ((order.length % n == 0) ?0:1);
			int[] tmpOrder = new int[gamesCount];
			int currentRank = gamesCount + 1;
			for (int i = 0; i != gamesCount; i ++){
				int max = -1;
				int maxIndex = -1;
				for (int j = i*n; j != i*n + n && j < order.length; j ++) {
					if (mice[order[j]] > max){
						max = mice[order[j]];
						if(maxIndex != -1)
							rank[maxIndex] = currentRank;
						maxIndex = order[j];	
					}else 
						rank[order[j]] = currentRank;
				}
				tmpOrder[i] = maxIndex;
			}
			order = tmpOrder;
		}
		
		rank[order[0]] = 1;
		
		for (int i = 0; i != rank.length; i ++){
			System.out.print(rank[i]);
			if (i != rank.length - 1)
				System.out.print(" ");
		}

	}
	
	
}
