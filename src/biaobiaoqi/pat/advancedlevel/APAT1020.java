package biaobiaoqi.pat.advancedlevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1.#Take care, it's binary tree, instead of binary search tree!!!
 * 2.Building tree is not necessary£¬ as the process of finding the node is just a level traversal. 
 * 3.# With a sequence of inorder traversal and another traversal, we can build the tree correctly.  
 * 
 * @author biaobiaoqi
 */
public class APAT1020 {
	public static final int max = 31;
	public static int[] post = new int[max];
	public static int[] in = new int[max];
	public static int n;
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		for (int i=0; i < n; ++i) {
			post[i] = cin.nextInt(); 
		}
		for (int i=0; i < n; ++i) {
			in[i] = cin.nextInt();
		}
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, n-1, 0, n-1));
		boolean head = true;
		while (queue.size() != 0) {
			Pair p = queue.poll();
			if (p.ps > p.pe) continue;
			
			if (head) head = false;
			else System.out.print(" ");
			System.out.print(post[p.pe]);
			
			if (p.ps == p.pe) continue;
			
			int i;
			for (i = p.is; i < p.ie; ++i) {
				if (in[i] == post[p.pe]){
					break;
				}
			}
			queue.add(new Pair(p.ps, 
					p.ps + i - p.is -1, 
					p.is, 
					i - 1));
			queue.add(new Pair(p.ps + i - p.is,
					p.pe - 1, 
					i + 1, 
					p.ie));
		}
	}

	public static class Pair {
		public int ps;
		public int pe;
		public int is;
		public int ie;
		public Pair(int s, int e, int is, int ie) {
			ps = s;
			pe = e;
			this.is = is;
			this.ie = ie;
		}
	}
	
}
