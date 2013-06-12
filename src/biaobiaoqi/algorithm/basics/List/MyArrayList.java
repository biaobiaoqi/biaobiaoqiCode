package biaobiaoqi.algorithm.basics.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 *  1.异常处理尽可能在正常业务逻辑前面。解开耦合。 
 *  2.构造方法中调用clear（）。不重复发明轮子。
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
		
		//注意这种泛型数组生成的书写方式
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
	
	//一种插入排序的方式。从大端开始。
	public void add (int idx, AnyType newVal) {
		if (idx == size()) {
			ensureCapacity(2 * size() + 1);
		}
		
		//边界的处理方式，用边界情况确定。比如，add(size(), newVal)的情况
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
			
			return theItems[ current ++]; //注意这里，current 的next的含义。
		}

		@Override
		public void remove() {
			//指向外部类对象的指针
			MyArrayList.this.remove(-- current);
		}
		
	}
	
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
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
	
	public static void showList(MyArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
