package biaobiaoqi.pat.advancedlevel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class APAT1043 {
	//define whether it can build a tree
	public static int n;
	public final static int max = 1001;
	public static int[] a = new int[max];
	public static boolean bst = true;
	public static Node root = null;
	public static Stack r = new Stack();
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		for (int i = 0; i < n; ++i) a[i] = cin.nextInt();
		
		root = buildTree(0, n - 1);
		
		if(!bst) System.out.println("NO");
		else {
			System.out.println("YES");
			printTree();
		}
	}
	
	//TODO mirror has not implemented:
	//1.if we can not decide it, it will not affect the result. but how can we build the tree?
	//2.how can we build the tree.
	//right start should not be s or e, as if it has not been processed, s or e can lead to infinite loop.
	//On one hand, it's the start position of right part, on the other hand, it can represent
	//the existing of right part, and it should can be used to distinguish such a condition.			
	public static Node buildTree(int s, int e) {
		if (s > e) return null;
			
		Node newNode = new Node(a[s]);
		int rightStart = e + 1;
		for (int i = s + 1; i <= e; i ++) {
			if (rightStart == e + 1 && a[i] >= a[s]) {
				rightStart = i;
			}else if (rightStart != e + 1 && a[i] < a[s]) {
				bst = false;
			}
		}
		
		newNode.left = buildTree(s + 1, rightStart - 1);
		newNode.right = buildTree(rightStart, e);
		return newNode;
	}
	
	public static void printTree(){
		postOrder(root);
	}
	
	public static boolean start = true;
	public static void postOrder(Node n) {
		if (n.left != null) postOrder(n.left);
		if (n.right != null) postOrder(n.right);
		
		if (start) start = false;
		else System.out.print(" ");
		System.out.print(n.value);
	}
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int i) {
			value = i;
		}
	}
}
