package biaobiaoqi.algorithm.sort;

import java.util.ArrayList;
import java.util.Iterator;

import biaobiaoqi.algorithm.tool.Tools;
/**
 * �������Լ��Ļ�������
 * 1.������ߵ���ֵ��Ϊpivot���趨�����α꣬�ֱ�Ϊlist����������ҡ�
 * 2.�����ƶ����αꡣֱ����ӦֵС��pivot��������α��Ӧ��ֵ������
 * 3.�����ƶ����αꡣֱ����Ӧֵ����pivot��������α��Ӧ��ֵ������
 * 4.�ظ�2��3��ֱ�������α��غϡ�
 * 5.�ݹ����2-4���������
 * 
 * �ܾ�û���㷨�ˣ�����д��һ��Сʱ����Ҫ�����¼�����Ҫע��ģ�
 * 1.Ū����㷨�еĽ�������
 * 2.�߽�ֵ��ȷ����
 * 	2.1�ݹ���Ӵ����п���ʱ���ִ�����ʼλ�úͽ���λ�ã�
 * 	2.2�ݹ���Ӵ����п���ʱ�����Ϊ0�ˣ�����ֲ�ͬ�ˡ���������ֱ��pos+1,pos-1�ˣ�
 * 3.ע���ظ�ֵ�����
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
			System.out.println("�����ַ���Ϊ��");
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


