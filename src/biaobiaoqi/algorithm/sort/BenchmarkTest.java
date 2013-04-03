package biaobiaoqi.algorithm.sort;
/**
 * 将所有的排序方式横向比较。
 * 问题：
 * 1.靠前的排序方式，将获得更好的效果。运行环境原因？
 * 2.排序数据超过8000后，quicksort会有stackoverflow的问题
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
