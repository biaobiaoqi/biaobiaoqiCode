package biaobiaoqi.algorithm.tree;
//TODO how to delete?
//
public class AVLTree {
	//if the Node n is null, it can return -1.
	private int height(Node n) {
		return (n == null)?-1:n.height;
	}
	
	public Node singleRotateWithLeftChild(Node t) {
		return t;
	}
	
	public Node doubleRotateWithLeftChild(Node t) {
		return t;
	}
	
	public Node singleRotateWithRightChild(Node t) {
		return t;
	}
	
	public Node doubleRotateWithRightChild(Node t) {
		return t;
	}
	
	public Node insert(Node t, int x) {
		if (t== null) t = new Node(x);
		else if (t.value > x){
			t = insert(t.leftChild, x);
			
			if (height(t.leftChild) == height(t.rightChild) + 2) {
				if (t.leftChild.value < x) 	
					t = singleRotateWithLeftChild(t);
				else
					t = doubleRotateWithLeftChild(t);
			}
		}
		else if (t.value < x) {
			t = insert(t.rightChild, x);
			if (height(t.leftChild) + 2 == height(t.rightChild)) {
				if (t.rightChild.value > x) 
					t = singleRotateWithRightChild(t);
				else
					t = doubleRotateWithRightChild(t);
			}
		}
		else 
			;
		t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1;
		
		return t;
	}
	
	
	public static class Node {
		public int value;
		public Node leftChild;
		public Node rightChild;
		public int height;
		public Node (int v){
			value = v;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
