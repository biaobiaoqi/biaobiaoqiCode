package biaobiaoqi.algorithm.basics.tree;

//TODO backtracking to delete
/**
 * 1.When inserting and rotation, the returning result of the recursive method is often wrong.
 * 
 * @author biaobiaoqi
 *
 */
public class AVLTree {
	private Node root;
	
	//there is one special case:if the Node n is null, it can return -1.
	//this method give such a wrappered solution.
	private int height(Node n) {
		return (n == null)?-1:n.height;
	}
	
	private Node singleRotateWithLeftChild(Node t) {
		Node tmp = t.leftChild;
		t.leftChild = tmp.rightChild;
		tmp.rightChild = t;
		t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1;
		tmp.height = Math.max(height(tmp.leftChild), height(tmp.rightChild)) + 1;
		return tmp;
	}

	private Node doubleRotateWithLeftChild(Node t) {
		t.leftChild = singleRotateWithRightChild(t.leftChild);
		t = singleRotateWithLeftChild(t);
		return t;
	}
	
	private Node singleRotateWithRightChild(Node t) {
		Node tmp = t.rightChild;
		t.rightChild = tmp.leftChild;
		tmp.leftChild = t;
		t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1;
		tmp.height = Math.max(height(tmp.leftChild), height(tmp.rightChild)) + 1;
		return tmp;
	}
	
	private Node doubleRotateWithRightChild(Node t) {
		t.rightChild = singleRotateWithLeftChild(t.rightChild);
		t = singleRotateWithRightChild(t);
		return t;
	}
	
	private Node insert(Node t, int x) {
		if (t== null) t = new Node(x);
		else if (t.value > x){
			t.leftChild = insert(t.leftChild, x);
			
			if (height(t.leftChild) == height(t.rightChild) + 2) {
				if (t.leftChild.value > x) 	
					t = singleRotateWithLeftChild(t);
				else
					t = doubleRotateWithLeftChild(t);
			}
		}
		else if (t.value < x) {
			t.rightChild = insert(t.rightChild, x);
			if (height(t.leftChild) + 2 == height(t.rightChild)) {
				if (t.rightChild.value < x) 
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
	
	public void insert(int x) {
		root = insert(root, x);
	}
	
	public void printTree() {
		preOrderTrav(root);
		System.out.println();
	}
	
	private void preOrderTrav(Node n) {
		if (n != null) {
			System.out.print(n.value + " ");
			preOrderTrav(n.leftChild);
			preOrderTrav(n.rightChild);
		}
	}

	public static class Node {
		public int value;
		public Node leftChild;
		public Node rightChild;
		public int height;
		public Node (int v){
			value = v; height = 0;
		}
	}
	
	public static void main(String[] args) {
		/*the pic of this tree is in page 97 of <data structure and algorithm in Java>*/
		AVLTree tree = new AVLTree();
		int[] a = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
		for (int i = 0; i < a.length; ++i) 
			tree.insert(a[i]);
		
		tree.printTree();
		
	}
}
