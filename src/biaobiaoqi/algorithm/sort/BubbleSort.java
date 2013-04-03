package biaobiaoqi.algorithm.sort;

import biaobiaoqi.algorithm.tool.Tools;
/**
 * 冒泡排序用自己的话表述：
 * 依次确定最大值，第二大的值。。。把这些最大值冒泡到最后
 * 每次都是遍历执行。
 * 
 * 
 * @author biaobiaoqi
 *
 */
public class BubbleSort extends BasicSort{
	public void sort(Integer[] list){
		for (int i = 0 ; i != list.length ; i++) {
			tools.showInProgressArray(list);
			
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j+1]) {
					int tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				}
			}
		}
	}
	
	
	public static void main (String[] args){
		BubbleSort sort = new BubbleSort();
		sort.testSort();	
	}
}