package biaobiaoqi.algorithm.basics.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * �������׳���ĵط��ǲ�������ı߽����⡣
 * 1. Ϊ�˷������������start��end �����������ݵĽڵ㡣
 * 2. Ϊ������һ���ԣ����������ʵ�ֵ�MyArrayList���ڲ���ֵʱ��ʹ��addbefore��˼·��
 *      [0,size-1]�ǵ�ǰ�Ѿ����ڵĽڵ㣬[0,size]��size+1��λ�ö�������Ϊ������±ꡣ
 *      ���������£�head�ӵ��tail�ڵ㲢���Եȡ�
 * 3. modCount�򵥵�ʵ���������״̬���������ڲ������ơ���Ȼ��״̬�����Ͳ�����clear()ʱ��ʼ����
 * 4. iterator�Ļ��ƱȽ�΢��:��״̬��modCount����������֤ɾ����next����ʱlistû�б��ı䡣
 * 5. iterator��okToRemove��Ǳ�֤ɾ�������ĺϷ��ԡ���һ���ڵ�ֻ��ɾ��һ�Σ�
 * 6. �ڲ���̬�� �� һ���ڲ��಻ͬ���ڲ���̬������ɲ���������һ���ⲿ�����
 * @author biaobiaoqi
 *
 * @param <AnyType>
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	//���ﲻ��static��û��warning��
	
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
	
	//���͵�constructor����Я������<>
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
		System.out.print("����list[0, 2]������(1,1)��\n ");
		list.add(0);
		list.add(2);
		
		list.add(1,1);
		showList(list);
		
		System.out.print("ɾ��(2)��\n ");
		list.remove(2);
		showList(list);
		
		
		System.out.print("��list����[10, 11, 12, 13]��\n ");
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		showList(list);
		
		System.out.print("ɾ��list�е�ż����\n ");
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
