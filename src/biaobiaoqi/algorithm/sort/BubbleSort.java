package biaobiaoqi.algorithm.sort;

import biaobiaoqi.algorithm.tool.Tools;
/**
 * ð���������Լ��Ļ�������
 * ����ȷ�����ֵ���ڶ����ֵ����������Щ���ֵð�ݵ����
 * ÿ�ζ��Ǳ���ִ�С�
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