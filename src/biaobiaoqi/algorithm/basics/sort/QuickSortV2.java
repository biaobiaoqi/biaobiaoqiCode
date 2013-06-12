package biaobiaoqi.algorithm.basics.sort;


import biaobiaoqi.algorithm.basics.Tools.Tools;

/**
 * �������Լ��Ļ�������
 * 1.������ߵ���ֵ��Ϊpivot���趨�����α꣬�ֱ�Ϊlist����������ҡ�
 * 2.�����ƶ����αꡣֱ����ӦֵС��pivot��������α��Ӧ��ֵ������
 * 3.�����ƶ����αꡣֱ����Ӧֵ����pivot��������α��Ӧ��ֵ������
 * 4.�ظ�2��3��ֱ�������α��غϡ�
 * 5.�ݹ����2-4���������
 * 
 * �ڶ���д�������˰����Сʱ����Ҫ������һ�㣺
 * 1.*�߽�ֵ���ȷ�����ڱ��㷨�У����Բ�������ֵΪ�����������ΪstartPos��Сֵ��ֻ����������endPos�Ǵ�ֵ��ֻ���С������ֻ��Ҫ�����������ĶԱȡ�
 * 2.����֧�����ظ�ֵ�����
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
			System.out.println("��������Ϊ�գ�");
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
