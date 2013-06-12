package biaobiaoqi.algorithm.basics.sort;

import biaobiaoqi.algorithm.basics.Tools.Tools;
/**
 * ѡ������
 * ����n�Σ�ÿ�β��ϱȽϱ�������Ԫ�أ�����ѡ����nС��Ԫ�أ�������list[n]��λ�á�
 * ��ð�ݵĲ�ͬ�ǣ����ݻ�������������һ�����ݵĹ��̣���ѡ���ʱ����ֱ�ӽ���Сֵ�ŵ���Ӧ��λ�á�
 * 
 * @author biaobiaoqi
 *
 */
public class SelectionSort extends BasicSort{
	
	public void sort(Integer[] list) {
		int minPos = 0;
		for (int i = 0; i != list.length; i ++) {
			minPos = i;
			for (int j = i; j < list.length; j++) {
				if (list[j] < list[minPos]) {
					minPos = j;
				}
			}
			
			if (minPos != i) {
				int tmp = list[i];
				list[i] = list[minPos];
				list[minPos] = tmp;
			}
		}
	}
	
	public static void main (String[] args) {
		SelectionSort sort = new SelectionSort();
		sort.testSort();
	}
}
