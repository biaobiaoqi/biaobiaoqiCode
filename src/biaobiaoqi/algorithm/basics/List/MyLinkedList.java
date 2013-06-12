package biaobiaoqi.algorithm.basics.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 这里容易出错的地方是插入操作的边界问题。
 * 1. 为了方便操作，有了start和end 两个不存数据的节点。
 * 2. 为了理解的一致性，类比于数组实现的MyArrayList，在插入值时，使用addbefore的思路。
 *      [0,size-1]是当前已经存在的节点，[0,size]这size+1个位置都可以作为插入的下标。
 *      在这个情况下，head接点和tail节点并不对等。
 * 3. modCount简单的实现了链表的状态计数，用于并发控制。既然是状态量，就不用再clear()时初始化。
 * 4. iterator的机制比较微妙:用状态量modCount做计数，保证删除、next操作时list没有被改变。
 * 5. iterator用okToRemove标记保证删除操作的合法性。（一个节点只能删除一次）
 * 6. 内部静态类 跟 一般内部类不同。内部静态类的生成不必依附于一个外部类对象。
 * @author biaobiaoqi
 *
 * @param <AnyType>
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	//这里不加static则没有warning。
	
	private static class MyNode<AnyType>{
		public AnyType value;
		public MyNode<AnyType> pre;
		public MyNode<AnyType> next;
		
		public MyNode(AnyType val, MyNode<AnyType> p, MyNode<AnyType> n) {
			value = val;
			pre = p;
			next = n;
		}
	}
	
	
	private MyNode<AnyType> startNode ;
	private MyNode<AnyType> EndNode;
	int theSize;
	int modCount = 0;  
	
	//泛型的constructor不能携带泛型<>
	public MyLinkedList () {
		clear();
	}
	
	public void clear() {
		startNode = new MyNode<AnyType>(null, null, null);
		EndNode = new MyNode<AnyType>(null, startNode, null);
		startNode.next = EndNode;
		
		theSize = 0;
	}
	
	
	public boolean isEmpty() {
		return theSize == 0;
	}
	
	
	
	public void add(AnyType val) {
		add(size(), val);
	}
	
	public void add(int pos, AnyType val) {
		addBefore(getNode(pos), val);
	}
	
	public void addBefore(MyNode<AnyType> nNode, AnyType val) {
		MyNode<AnyType> pNode = nNode.pre;
		MyNode<AnyType> newNode = new MyNode<AnyType>(val, pNode, nNode);

		pNode.next = newNode;
		nNode.pre = newNode;

		theSize ++;
		modCount ++;
	}
	
	public MyNode<AnyType> getNode(int pos) {
		if (pos < 0 || pos > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		MyNode<AnyType> tmpNode;
		
		if (pos < theSize/2) {
			tmpNode = startNode.next;
			for (int i = 0; i != pos; i ++) {
				tmpNode = tmpNode.next;
			}
			
		}else {
			tmpNode = EndNode;
			for (int i = theSize; i != pos; i --) {
				tmpNode = tmpNode.pre;
			}
		}
		
		return tmpNode;
	}
	
	public void remove(int pos) {
		if (pos < 0 || pos >= theSize) {
			throw new IndexOutOfBoundsException();
		}
		
		MyNode<AnyType> removingNode = getNode(pos);
		removingNode.pre.next = removingNode.next;
		removingNode.next.pre = removingNode.pre;
		
		theSize --;
		modCount ++;
	}
	
	
	public void set(int pos, AnyType val) {
		MyNode<AnyType> tmpNode = getNode(pos);
		tmpNode.value = val;
	}
	
	public int size() {
		return theSize;
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return new MyIterator();
	} 
	
	private class MyIterator implements Iterator<AnyType> {
		private int itModCount = modCount;
		private boolean okToRemove = false;
		private MyNode<AnyType> itNode = startNode.next;
		
		
		public AnyType next() {
			if(itModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			AnyType nextItem = itNode.value;
			itNode = itNode.next;
			okToRemove = true;
			
			return nextItem;
		}
		
		public boolean hasNext() {
			if (itModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			
			return itNode != EndNode;
		}
		
		public void remove() {
			if (itModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			
			itNode.pre.next = itNode.next;
			itNode.next.pre = itNode.pre;
			okToRemove = true;
		}
	}
	
	
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		System.out.print("创建list[0, 2]，插入(1,1)：\n ");
		list.add(0);
		list.add(2);
		
		list.add(1,1);
		showList(list);
		
		System.out.print("删除(2)：\n ");
		list.remove(2);
		showList(list);
		
		
		System.out.print("向list增加[10, 11, 12, 13]：\n ");
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		showList(list);
		
		System.out.print("删除list中的偶数：\n ");
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer iVal = it.next();
			if (iVal % 2 == 0) {
				it.remove();
			}
		}
		showList(list);
	}
	
	public static void showList(MyLinkedList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

	}
	
}
