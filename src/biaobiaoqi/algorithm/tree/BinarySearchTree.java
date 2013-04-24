package biaobiaoqi.algorithm.tree;

/**
 * 1.���㷨�����������������ơ���ͬ�������ܶ�̬���ӡ�ɾ���ڵ�ͬʱ��֤�����ԣ����������ܡ�
 * 2.��Ҫʹ�õݹ�����ģ��ݹ������Ϊprivate���������û����õĽӿڷ�����Ϊ�������򣬵�����Ӧ�ĵݹ鷽����
 * 3.�ݹ�Ĺ����У����ڽ��޵��ж����ڵݹ���̵Ŀ�ͷ�����д����������ĵĵݹ��߼�����������ֿ���
 * 4.O(n*logn)  ��(n*n)
 * @author biaobiaoqi
 *
 */
public class BinarySearchTree {
	public Node root;
	
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
				//��δ�����ܳ���
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
		inorderTrav(root);
		//preOrderTrav(root);
		//postOrderTrav(root);
		System.out.println();
	}
	
	public void inorderTrav(Node n) {
		if (n != null) {
			inorderTrav(n.leftNode);
			System.out.print(n.value + " ");
			inorderTrav(n.rightNode);
		}
	}
	
	public void preOrderTrav(Node n) {
		if (n != null) {
			System.out.print(n.value + " ");
			preOrderTrav(n.leftNode);
			preOrderTrav(n.rightNode);
		}
	}
	
	public void postOrderTrav(Node n) {
		if (n != null) {
			postOrderTrav(n.leftNode);
			postOrderTrav(n.rightNode);
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
		tree.insert(10);
		tree.insert(16);
		tree.insert(2);
		tree.insert(8);
		tree.insert(7);
		tree.insert(24);
		tree.insert(1);
		tree.insert(13);
		tree.insert(9);
		tree.printTree();	

		int testRemove = 10;	
		System.out.println("contains " + testRemove + "?: " + (tree.contains(testRemove)? "YES" : "NO" ));
	
		tree.remove(testRemove);
		tree.printTree();
		System.out.println("contains " + testRemove + "?: " + (tree.contains(testRemove)? "YES" : "NO" ));
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
