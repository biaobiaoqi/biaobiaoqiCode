package biaobiaoqi.algorithm.sort;
/**
 * �����е�����ʽ����Ƚϡ�
 * ���⣺
 * 1.��ǰ������ʽ������ø��õ�Ч�������л���ԭ��
 * 2.�������ݳ���8000��quicksort����stackoverflow������
 * @author biaobiaoqi
 *
 */

public class BenchmarkTest {
	
	public static void main (String[] args) {
		BasicSort[] sortArray = {
				new BubbleSort(), new QuickSortV2(), 
				new QuickSort(), new SelectionSort(),  
				new InsertionSortV2(),
				new ShellSort(), new HeapSort(),
				new MergeSort()
				} ;
		for (int i = 0 ; i != sortArray.length; i ++) {
			sortArray[i].testSort(7000);
		}
	}
}
