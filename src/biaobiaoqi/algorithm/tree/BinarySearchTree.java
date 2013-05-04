package biaobiaoqi.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1.其算法本身跟快速排序很相似。不同在于树能动态增加、删除节点同时保证有序性，而快排则不能。
 * 2.需要使用递归操作的，递归操作作为private方法，而用户调用的接口方法作为驱动程序，调用相应的递归方法。
 * 3.递归的过程中，对于界限的判定放在递归过程的开头，集中处理，而将核心的递归逻辑与结束点区分开。
 * 4.O(n*logn)  Ω(n*n)
 * @author biaobiaoqi
 *
 */
public class BinarySearchTree {
	public Node root;
	public static final int max = 100;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(int i) {
		Node newNode = new Node(i);
		root = insert(root, newNode);
	}
	
	private Node insert(Node oriNode, Node newNode) {
		if (oriNode == null) 
			return newNode;
		
		else if (oriNode.value < newNode.value) {
			oriNode.rightNode = insert(oriNode.rightNode, newNode);
			return oriNode;
		}else if (oriNode.value > newNode.value) {
			oriNode.leftNode = insert(oriNode.leftNode, newNode);
			return  oriNode;
		}
		
		else return oriNode;

	}
	
	public void remove(int n) {
		root = remove(root, n);
	}
	
	private Node remove(Node oriNode, int n) {
		if(oriNode == null) return null;
			
		else if (oriNode.value == n) {
			if (oriNode.leftNode != null && oriNode.rightNode != null) {
				//这段代码可能出错
				oriNode.value = findMin(oriNode.rightNode).value;
				oriNode.rightNode = remove(oriNode.rightNode, oriNode.value); 
				return oriNode;
			}else return ((oriNode.leftNode != null) ? oriNode.leftNode : oriNode.rightNode);
			
		}else if (oriNode.value < n){
			oriNode.rightNode = remove(oriNode.rightNode, n);
			return oriNode;
			
		}else if (oriNode.value > n) {
			oriNode.leftNode = remove(oriNode.leftNode, n);				
			return oriNode;
		}
		
		return oriNode;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int findMin() throws Exception{
		if (isEmpty()) throw new Exception();
		
		return findMin(root).value;
	}
	
	private Node findMin(Node oriNode) {
		if (oriNode != null)
			while(oriNode.leftNode != null) 
				oriNode = oriNode.leftNode;
		
		return oriNode;
	}
	
	public int findMax() throws Exception {
		if(isEmpty())	throw new Exception();
		return findMax(root).value;
	}
	
	//use non-recursive method as we can to save stack
	private Node findMax(Node oriNode) {
		if (oriNode != null) 
			while (oriNode.rightNode != null) 
				oriNode = oriNode.rightNode;
		
		return oriNode;
	}
	
	public void printTree() {
		//inorderTrav(root);
		preOrderTrav(root);
		//postOrderTrav(root);
		System.out.println();
		
		preOrderTravNoRecur(root);
		preOrderTravNoRecurII(root);
		System.out.println();
		
		levelOrderTrav(root);
	}
	
	public void levelOrderTrav(Node n) {
		System.out.print("Level OrderTrav: ");
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (q.size() != 0) {
			n = q.poll();
			System.out.print(" " + n.value);
			if (n.leftNode != null) 
				q.add(n.leftNode);
			if (n.rightNode != null)
				q.add(n.rightNode);

		}
	}
	
	public void inorderTrav(Node n) {
		if (n != null) {
			inorderTrav(n.leftNode);
			System.out.print(n.value + " ");
			inorderTrav(n.rightNode);
		}
	}
	
	public void inorderTravNoRecu(Node n) {
		System.out.println("No Recursive: ");
		Stack<Node> s = new Stack<Node>();
		while (n != null | !s.empty()){
			while (n!=null ){
				s.push(n);
				n = n.leftNode;
			}
			n = s.pop();
			System.out.print(n.value + " ");
			n = n.rightNode;
		}
	}
	
	public void preOrderTrav(Node n) {
		if (n != null) {
			System.out.print(n.value + " ");
			preOrderTrav(n.leftNode);
			preOrderTrav(n.rightNode);
		}
	}

	public void preOrderTravNoRecur(Node n) {
		System.out.println("No Recursive: ");
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.empty()) {
			Node t = stack.pop();
			System.out.print(t.value + " ");
			if (t.rightNode != null)
				stack.add(t.rightNode);
			if (t.leftNode != null)
				stack.add(t.leftNode);
		}
		System.out.println();
	}
	/*
	 * 		 10
	 * 	 2		  16
	 *1    8	13  24
	 *    7 9
	 * */

	public void preOrderTravNoRecurII(Node n) {
		System.out.println("No Recursive: ");
		Stack<Node> s = new Stack<Node>();
		while (n != null | !s.empty()){
			while (n!=null ){
				System.out.print(n.value + " ");
				s.add(n);
				n = n.leftNode;
			}
			n = s.pop();
			n = n.rightNode;
		}
		System.out.println();
	}
	
	public void postOrderTrav(Node n) {
		if (n != null) {
			postOrderTrav(n.leftNode);
			postOrderTrav(n.rightNode);
			System.out.print(n.value + " ");
		}
	}
	
	public void postOrderTravNoRecu(Node n) {
		/*
初始：1.维护一个栈S、一个节点变量N和一个标记数组。节点变量赋值为根节点，栈暂时存储便利到的节点，标记数组用于标记栈中的节点是否已经访问过右边节点。
	2.将根节点的所有左儿子压入栈中。
循环：依次处理栈中节点。如果节点有右儿子，且没有被处理过（通过标记数组判定），则将右子树的根节点及其左儿子全部压入栈中；如果已经处理过或者没有右儿子，则输出并出栈。
分析：与前序和中序的一个大的不同在于需要用标记数组标记节点的右子树是否已经访问过。对每个节点进行处理的时候，都保证已经处理完了左右子树（通过先压入左边儿子为主线，处理栈中的每个节点时，再压入右边儿子来实现）。

		 */
		
		Stack<Node> stack = new Stack<Node>();
		int[] flag = new int[max];
		
		while (n != null) {
			stack.push(n);
			flag[stack.size()] = 0;
			n = n.leftNode;
		}
		
		while (!stack.empty()) {
			n = stack.peek();
			while(n.rightNode != null && flag[stack.size()] == 0) {
				n = n.rightNode;
				flag[stack.size()] = 1;
				while (n != null) {
					stack.push(n);
					flag[stack.size()] = 0;
					n = n.leftNode;
				}
				n = stack.peek();//TODO be careful about this
			}
			n = stack.pop();
			System.out.print(n.value + " ");
		}
		
	}
	

	
	public boolean contains(int n) {
		return containsNode(root, n);
	}
	
	public boolean containsNode(Node node, int n) {
		if (node == null)  return false;
		else if (node.value == n) 	return true;
		else if (node.value < n)  return containsNode(node.rightNode, n);
		else return containsNode(node.leftNode, n);
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] a = {10, 16, 2, 8, 7, 24, 1, 13, 9};
		for (int i = 0; i < a.length; ++i) 
			tree.insert(a[i]);
		
		tree.printTree();

//		int testRemove = 10;	
//		System.out.println("contains " + testRemove + "?: " + (tree.contains(testRemove)? "YES" : "NO" ));
//	
//		System.out.println("\nAfter Removing " + testRemove + ":");		
//		tree.remove(testRemove);
//		tree.printTree();
//		System.out.println("contains " + testRemove + "?: " + (tree.contains(testRemove)? "YES" : "NO" ));
	}
	
	public class Node {
		public int value;
		public Node leftNode;
		public Node rightNode;
		
		public Node(int i) {
			value = i;
		}
	}
}
