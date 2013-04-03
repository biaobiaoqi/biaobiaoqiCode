package biaobiaoqi.algorithm.sort;

import java.util.ArrayList;
import java.util.Iterator;

import biaobiaoqi.algorithm.tool.Tools;
/**
 * 快排用自己的话表述：
 * 1.将最左边的数值作为pivot；设定两个游标，分别为list的最左和最右。
 * 2.向左移动右游标。直到对应值小于pivot，则跟左游标对应的值交换；
 * 3.向右移动左游标。直到对应值大于pivot，则跟右游标对应的值交换。
 * 4.重复2，3，直到左右游标重合。
 * 5.递归调用2-4，完成排序。
 * 
 * 很久没编算法了，快排写了一个小时。主要有如下几点需要注意的：
 * 1.弄清楚算法中的交换规则。
 * 2.边界值的确定。
 * 	2.1递归对子串进行快排时，字串的起始位置和结束位置；
 * 	2.2递归对子串进行快排时，如果为0了，情况又不同了。（不可以直接pos+1,pos-1了）
 * 3.注意重复值的情况
 * 
 * @author biaobiaoqi
 *
 */
public class QuickSort extends BasicSort{
	public void quickSort(Integer [] list, int startPos, int endPos)
	{
		//System.out.print("[" + startPos + "," + endPos + "]");
		tools.showInProgressArray(list);
		
		
		int pivot = list[startPos];
		int oriStartPos = startPos;
		int oriEndPos = endPos;
		
		if (startPos == endPos) {
			return;
		}
		
		while(startPos < endPos){
			while (endPos > startPos && list[endPos] > pivot) {
				endPos --;
			}
			list[startPos] = list[endPos];
			list[endPos] = pivot;
			
			while (endPos > startPos && list[startPos] <= pivot) {
				startPos ++;
			}
			list[endPos] = list[startPos];
			list[startPos] = pivot;
		}
		
		if (oriStartPos < startPos -1) {
			this.quickSort(list, oriStartPos, startPos-1);			
		}

		if (endPos +1 < oriEndPos){
			this.quickSort(list, endPos+1, oriEndPos);			
		}

	}
	
	public void sort(Integer [] list){
		if (list.length == 0) {
			System.out.println("输入字符串为空");
		}else {
			this.quickSort(list, 0, list.length -1);
		}
	}
	
	
	public static void main(String[] args)
	{
		//34,3,53,2,23,7,14,10
		//< 10,3,53,2,23,7,14,34_ 
		//> 10,3,34_,2,23,7,14,53_ 
		//< 10,3,14_,2,23,7,34_,53
		//> 10,3,14,2,23,7,34_,53
		QuickSort sort = new QuickSort();
		sort.testSort();
	
	}
 
}


