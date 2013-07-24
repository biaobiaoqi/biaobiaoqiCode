package biaobiaoqi.algorithm.basics.tree;
/**
 * 树状数组介绍：http://hawstein.com/posts/binary-indexed-trees.html
 * 其中int lowbit(int x)为最核心的算法，int sum(int x)和void update(int x, int value)常用，而int read(int x)方法可以使用一般数组来O(1)得到，故不常用。
 * @author biaobiaoqi
 *
 */
public class BinaryIndexedTree {
	public static int max = 1000;
	public static int[] ar = new int[max];
	public static int[] tr = new int[max];
	
	public static int lowbit(int x) {
		return x & -x;
	}
	
	public static int sum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += tr[x];
			x -= lowbit(x);
		}
		return sum;
	}
	
	public static void update(int x, int value) {
		int delta = value - ar[x];
		ar[x] += delta;
		while(x < max) {
			tr[x] += delta;
			x += lowbit(x);
		}
	}
	
	public static int read(int x) {
		int value = tr[x];
		int z = x - lowbit(x);
		-- x;
		while(x != z) {
			value -= tr[x]; 
			x -= lowbit(x);
		}
		return value;
	}
	
	public static void main(String[] args) {
		for (int  i= 1; i != 10; ++ i) {
			update(i, 1);
		}
		
		for (int i = 1; i != 10; ++ i) 
			System.out.print(" " + read(i));
		
		for (int  i= 1; i != 10; ++ i) {
			update(i, i);
		}
		
		for (int i = 1; i != 10; ++ i) 
			System.out.print(" " + read(i));
	}
	
}
