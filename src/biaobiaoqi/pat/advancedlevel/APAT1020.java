package biaobiaoqi.pat.advancedlevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1.The inorder array means nothing.
 * 2.Building tree is not nessary.
 * 3.Why it's wa for the last test case.?TODO
 * 
 * @author biaobiaoqi
 *
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
			post[i]= cin.nextInt(); 
		}
		for (int i=0; i < n; ++i) {
			in[i]= cin.nextInt(); 
		}
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, n-1));
		boolean head = true;
		while (queue.size() != 0) {
			Pair p = queue.poll();
			if (p.start > p.end) continue;
			
			if (head) head = false;
			else System.out.print(" ");
			System.out.print(post[p.end]);
			
			if (p.start == p.end) continue;
			
			int max = p.start -1;
			for (int i=p.start; i < p.end; ++i) {
				if (post[i] < post[p.end]){
					max = i;
				}
			}
			queue.add(new Pair(p.start, max));
			queue.add(new Pair(max+1, p.end-1));
		}
	}
	
	public static class Pair {
		public int start;
		public int end;
		public Pair(int s, int e) {
			start = s;
			end = e;
		}
	}
}
