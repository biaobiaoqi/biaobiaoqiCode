package biaobiaoqi.algorithm.basics.sort;
/**
 * 插入排序
 * 
 * 相比第一个版本，V2的插入排序代码和处理思路要更简洁。
 * 第一个版本中，判定插入位置是从排好序的序列的小端开始。
 * 而V2版本则是从大端开始。好处是少了一层循环，少了break这种难于理解的逻辑。
 * 
 * @author biaobiaoqi
 *
 */
public class InsertionSortV2 extends BasicSort{
	public void sort(Integer[] list) {
		for (int i = 0; i != list.length; i ++) {
			int j ;
			int tmp = list[i];
			for (j = i; j - 1>= 0 && tmp < list[j - 1]; j --) {
				list[j] = list[j - 1];
			}
			list[j] = tmp;
		}
	}
	
	
	public static void main (String[] args) {
		InsertionSortV2 sort = new InsertionSortV2();
		sort.testSort(20);
	
	}
}
