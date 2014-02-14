package biaobiaoqi.algorithm.basics.sort;
/**
 * 堆排序：
 * 利用了最大堆在数组中排序。核心操作时percolateDown.
 * 
 * 注意：
 * 1.在数组中的节点位置（root接点为0）。比如做儿子为2*n+1，使用percolatedown时，初始位置为length/2-1.
 * 2.记住初期buildheap的时候，不是每个插入。而是从倒数第二层向root节点percolateDown（特别注意不是从root向下做）
 * 
 * @author biaobiaoqi
 *
 */
public class HeapSort extends BasicSort{

	public int leftChild(int n) {
		return 2*n + 1;
	}	
	
	public void percolateDown(Integer[] list, int n, int length) {
		int tmp;
		int child;
		
		for (tmp = list[n]; leftChild(n) < length; n = child) {
			child = leftChild(n);
			
			if (child + 1 < length && list[child] < list[child + 1]) {
				child ++;
			}
			
			if (tmp < list[child]) {
				list[n] = list[child];
			}else {
				break;
			}
		}
		tools.showInProgressArray(list);
		
		list[n] = tmp;
	}
	
	
	public void sort(Integer[] list) {
		//buildHash
		for (int i = list.length/2 - 1; i >= 0; i --) {
			percolateDown(list, i, list.length);
		}
		
		//switch and percolatedown
		for (int i = list.length - 1; i > 0; i --) {
			int tmp = list[i];
			list[i] = list[0];
			list[0] = tmp;
			
			percolateDown(list, 0, i);
		}
	}

	public  static void main(String[] args) {
		HeapSort sort = new HeapSort();
		Integer[] list = {10,7,2,8,1,5,11};
		//sort.testSort(list);
		sort.testSort(18);
	}
}
