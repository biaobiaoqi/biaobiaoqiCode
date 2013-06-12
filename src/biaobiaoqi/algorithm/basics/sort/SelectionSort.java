package biaobiaoqi.algorithm.basics.sort;

import biaobiaoqi.algorithm.basics.Tools.Tools;
/**
 * 选择排序：
 * 遍历n次，每次不断比较遍历到的元素，依次选出第n小的元素，交换到list[n]的位置。
 * 与冒泡的不同是，泡泡会两两交换，是一个传递的过程，而选择的时候，是直接将最小值放到对应的位置。
 * 
 * @author biaobiaoqi
 *
 */
public class SelectionSort extends BasicSort{
	
	public void sort(Integer[] list) {
		int minPos = 0;
		for (int i = 0; i != list.length; i ++) {
			minPos = i;
			for (int j = i; j < list.length; j++) {
				if (list[j] < list[minPos]) {
					minPos = j;
				}
			}
			
			if (minPos != i) {
				int tmp = list[i];
				list[i] = list[minPos];
				list[minPos] = tmp;
			}
		}
	}
	
	public static void main (String[] args) {
		SelectionSort sort = new SelectionSort();
		sort.testSort();
	}
}
