package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class APAT1043 {
	//define whether it can build a tree
	public static int n;
	public final static int max = 1001;
	public static int[] a = new int[max];
	public static boolean bst = true;
	public static Queue<Integer> rqueue = new LinkedList<Integer>();
	public static int mirror;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		for (int i = 0; i < n; ++i) a[i] = cin.nextInt();
		
		buildTree(0, n - 1, false);
		if (!bst) {
			rqueue.clear();
			bst = true;
			buildTree(0, n - 1, true);
		}
		
		if(!bst) System.out.println("NO");
		else {
			System.out.println("YES");
			boolean start = true;
			
			while (rqueue.size() != 0) {
				if (start) start = false;
				else System.out.print(" ");
				System.out.print(rqueue.poll());
			}
		}
	}

	//rtreeStart should not be s or e, as if it has not been processed, s or e can lead to infinite loop.
	//On one hand, it's the start position of right part, on the other hand, it can represent
	//the existing of right part, and it should can be used to distinguish such a condition.			
	public static void buildTree(int root, int end, boolean mirror) {
		if (root > end) return ;

		int rtreeStart = end + 1;
		for (int i = root + 1; i <= end; i ++) {
			if (!mirror) {
				//find the start node of right tree.
				if (rtreeStart > end  && a[i] >= a[root]) {
					rtreeStart = i;
				}else if (rtreeStart <= end && a[i] < a[root]) {
					bst = false;
				}
			}
			else {
				if (rtreeStart > end  && a[i] < a[root]) {
					rtreeStart = i;
				}else if (rtreeStart <= end && a[i] >= a[root]) {
					bst = false;
				}
			}
		}

		//post order traversal
		buildTree(root + 1, rtreeStart - 1, mirror);
		buildTree(rtreeStart, end, mirror);
		rqueue.add(a[root]);
	}	
}