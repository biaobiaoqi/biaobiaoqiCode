package biaobiaoqi.pat.advancedlevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * It doesn't need to build a tree, as in some case, a tree can not be defined.
 * @author biaobiaoqi
 */
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

	//1.if we can not decide it, it will not affect the result. but how can we build the tree?
	//2.how can we build the tree.
	//right start should not be s or e, as if it has not been processed, s or e can lead to infinite loop.
	//On one hand, it's the start position of right part, on the other hand, it can represent
	//the existing of right part, and it should can be used to distinguish such a condition.			
	public static void buildTree(int s, int e, boolean mirror) {
		if (s > e) return ;
		
		int rightStart = e + 1;
		for (int i = s + 1; i <= e; i ++) {
			if (!mirror) {
				if (rightStart > e  && a[i] >= a[s]) {
					rightStart = i;
				}else if (rightStart <= e && a[i] < a[s]) {
					bst = false;
				}
			}
			else {
				if (rightStart > e  && a[i] < a[s]) {
					rightStart = i;
				}else if (rightStart <= e && a[i] >= a[s]) {
					bst = false;
				}
			}
		}
		
		buildTree(s + 1, rightStart - 1, mirror);
		buildTree(rightStart, e, mirror);
		rqueue.add(a[s]);
	}
	
}