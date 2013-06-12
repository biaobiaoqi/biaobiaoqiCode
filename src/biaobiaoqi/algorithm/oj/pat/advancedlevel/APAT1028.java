package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;
/**
 * There are many ways :
 * 1.Let containers sort them by proving comparing methods.
 * 2.Implement binary sort myself.
 * Let's try the second one first.
 * 
 * TODO In the last test case, met with timeout error. I've checked out that it happened when input data.
 * It's Java's problem, not algorithm. 
 * @author biaobiaoqi
 *
 */

public class APAT1028 {
	public static Node root = null;
	public static int c ;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		c = cin.nextInt();
		
		Node newNode = null;
		while (n != 0) {
			--n;
			newNode = new Node(cin.next(), cin.next(), cin.nextInt());
			root = insertOne(root, newNode);
		}

		print(root);
	}
	
	public static void print(Node node) {
		if (node != null) {
			print(node.left);
			System.out.println(node.idString + " " + node.name + " " + node.score);	
			print(node.right);
		}
	}
	
	public static Node insertOne(Node oldNode, Node newNode) {
		if (oldNode == null) {
			oldNode = newNode;
		}else {
			int compare = compare(oldNode, newNode);
			
			if (compare < 0) {
				if (oldNode.right != null) {
					insertOne(oldNode.right, newNode);
				}else {
					oldNode.right = newNode;
				}
			}else {
				if(oldNode.left != null) {
					insertOne(oldNode.left, newNode);
				}else {
					oldNode.left = newNode;
				}
			}
		}
		return oldNode;
	}
	
	public static int compare(Node n1, Node n2) {
		int result = 0;
		int k1 = Integer.parseInt(n1.idString);
		int k2 = Integer.parseInt(n2.idString);
		if (c == 1) {
			return (k1 < k2)? -1 : 1;
		}
		if (c == 2) {
			int tmp = n1.name.compareTo(n2.name);
			if (tmp == 0) {
				return k1 < k2? -1 : 1;
			}else {
				return tmp;
			}
		}
		if (c == 3) {
			if (n1.score == n2.score) {
				return k1 < k2? -1 : 1;
			}else {
				return n1.score < n2.score? -1 : 1;
			}
		}
		return result;
	}
	
	
	public static class Node{
		String idString;
		String name;
		int score;
		
		Node left ;
		Node right ;
		
		public Node(String idString, String name, int s) {
			this.idString = idString;
			this.name = name;
			score = s;
			left = null;
			right = null;
		}
	}
}
