package biaobiaoqi.algorithm.basics.sort;
/**
 * 	希尔排序/缩减增量序列排序：
 * 		对插入排序的优化。将整个序列分为相同间隔的很多组，每组依次进行插入排序。主键缩减组中每个元素之间的间隔，最终实现
 * 	整个序列的排序。
 *	
 *	这里的插入排序，按照InsertionSortV2执行。如果是InsertionSort中的算法执行，则整个shellsort需要四层循环。可见
 *InsertionSortV2要更简洁。
 * @author biaobiaoqi
 *
 */
public class ShellSort extends BasicSort{
	public void sort(Integer[] list) {
		for (int gap = list.length/2; gap > 0; gap /= 2) {
			
			for (int i = gap; i < list.length; i++) {
				int tmp = list[i];
				int j;
				for (j = i ; j >= gap && list[j - gap] > tmp ; j -= gap) {
					list[j] = list[j - gap];
				}
				list[j] = tmp;
			}
		}
	}
	
	public  static void main(String[] args) {
		
		ShellSort sort = new ShellSort();
		sort.testSort();
	}
}
