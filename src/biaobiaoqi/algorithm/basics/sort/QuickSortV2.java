package biaobiaoqi.algorithm.basics.sort;


import biaobiaoqi.algorithm.basics.Tools.Tools;

/**
 * 快排用自己的话表述：
 * 1.将最左边的数值作为pivot；设定两个游标，分别为list的最左和最右。
 * 2.向左移动右游标。直到对应值小于pivot，则跟左游标对应的值交换；
 * 3.向右移动左游标。直到对应值大于pivot，则跟右游标对应的值交换。
 * 4.重复2，3，直到左右游标重合。
 * 5.递归调用2-4，完成排序。
 * 
 * 第二遍写还是用了半个多小时。主要有如下一点：
 * 1.*边界值如何确定。在本算法中，可以不考虑数值为正的情况。因为startPos是小值，只会增长，而endPos是大值，只会减小。于是只需要考虑他们两的对比。
 * 2.还不支持有重复值的情况
 * 
 * @author biaobiaoqi
 *
 */

public class QuickSortV2 extends BasicSort{
	public int getMiddle(Integer[] list, int startPos, int endPos){
		int leftPos = startPos;
		int rightPos = endPos;
		int pivot = list[startPos];
		
		while (leftPos < rightPos) {
			while (list[rightPos] > pivot && rightPos > leftPos) {
				rightPos --;
			}
			list[leftPos] = list[rightPos];
			list[rightPos] = pivot;
			
			while (list[leftPos] <= pivot && leftPos < rightPos) {
				leftPos ++;
			}
			list[rightPos] = list[leftPos];
			list[leftPos] = pivot;
			
			//System.out.print("[" + leftPos + "," + rightPos + "] pivot:" + pivot + " : ");
			tools.showInProgressArray(list);
		}
		
		return rightPos;
	}
	
	
	public void quickSort(Integer[] list, int startPos, int endPos){
		int middle = this.getMiddle(list, startPos, endPos);
		
		if (startPos < middle -1) {
			this.quickSort(list, startPos, middle - 1);
		}
		
		if (endPos > middle + 1) {
			this.quickSort(list, middle + 1, endPos);
		}
	}
	
	public void sort(Integer[] list){
		if (list.length == 0) {
			System.out.println("输入数组为空！");
		}else {
			this.quickSort(list, 0, list.length -1);
		}
	}
	
	
	public static void main(String[] args){  
		//34,3,53,2,23,7,14,10
		//< 10,3,53,2,23,7,14,34_ 
		//> 10,3,34_,2,23,7,14,53_ 
		//< 10,3,14_,2,23,7,34_,53
		//> 10,3,14,2,23,7,34_,53
		
		QuickSortV2 sortV2 = new QuickSortV2();
		sortV2.testSort();
	}
}
