package biaobiaoqi.algorithm.basics.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 *  1.�쳣��������������ҵ���߼�ǰ�档�⿪��ϡ� 
 *  2.���췽���е���clear���������ظ��������ӡ�
 *  
 * @author biaobiaoqi
 *
 * @param <AnyType>
 */
public class MyArrayList<AnyType> implements Iterable<AnyType>{
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private AnyType[] theItems;

	public MyArrayList(){
		clear();
	}
	

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size () {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void trimToSie() {
		ensureCapacity(size());
	}
	
	public AnyType getAnyType (int idx ) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return theItems[idx];
	}
	
	public  AnyType set(int idx, AnyType newVal) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
	
		AnyType oldVal = theItems[idx];
		theItems[idx] = newVal;
		return oldVal;
	}
	
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size()) {
			return;
		}
		
		//ע�����ַ����������ɵ���д��ʽ
		AnyType[] newItems = (AnyType[]) new Object[newCapacity];
		for (int i = 0 ; i != size(); i ++ ) {
			newItems[i]  = theItems[i];
		}
		
		theItems = newItems;
	}
	
	public boolean add (AnyType x) {
		add(size(), x);
		return true;
	}
	
	//һ�ֲ�������ķ�ʽ���Ӵ�˿�ʼ��
	public void add (int idx, AnyType newVal) {
		if (idx == size()) {
			ensureCapacity(2 * size() + 1);
		}
		
		//�߽�Ĵ���ʽ���ñ߽����ȷ�������磬add(size(), newVal)�����
		for (int i = size(); i > idx; i --) {
			theItems[i] = theItems[i -1];
		}
		
		theItems[idx] = newVal;
		
		theSize ++;
	}
	
	public AnyType remove (int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		AnyType val = theItems[idx];
		for (int i = idx ; i < size() - 1; i ++ ){
			theItems[i] = theItems[i + 1];
		}
		
		theSize --;
		
		return val;
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<AnyType> {
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public AnyType next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			return theItems[ current ++]; //ע�����current ��next�ĺ��塣
		}

		@Override
		public void remove() {
			//ָ���ⲿ������ָ��
			MyArrayList.this.remove(-- current);
		}
		
	}
	
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
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
	
	public static void showList(MyArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
