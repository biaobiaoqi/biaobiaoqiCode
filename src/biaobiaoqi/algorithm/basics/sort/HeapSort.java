package biaobiaoqi.algorithm.basics.sort;
/**
 * ������
 * ���������������������򡣺��Ĳ���ʱpercolateDown.
 * 
 * ע�⣺
 * 1.�������еĽڵ�λ�ã�root�ӵ�Ϊ0��������������Ϊ2*n+1��ʹ��percolatedownʱ����ʼλ��Ϊlength/2-1.
 * 2.��ס����buildheap��ʱ�򣬲���ÿ�����롣���Ǵӵ����ڶ�����root�ڵ�percolateDown���ر�ע�ⲻ�Ǵ�root��������
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
