package biaobiaoqi.algorithm.basics.sort;
/**
 * 	ϣ������/����������������
 * 		�Բ���������Ż������������з�Ϊ��ͬ����ĺܶ��飬ÿ�����ν��в�������������������ÿ��Ԫ��֮��ļ��������ʵ��
 * 	�������е�����
 *	
 *	����Ĳ������򣬰���InsertionSortV2ִ�С������InsertionSort�е��㷨ִ�У�������shellsort��Ҫ�Ĳ�ѭ�����ɼ�
 *InsertionSortV2Ҫ����ࡣ
 * @author biaobiaoqi
 *
 */
public class ShellSort extends BasicSort{
	public void sort(Integer[] list) {
		for (int gap = list.length/2; gap > 0; gap /= 2) {
			
			for (int i = gap; i < list.length; i++) {
				int tmp = list[i];
				int j;
				for (j = i ; j >= gap && list[j - gap] > tmp ; j -= gap) {
					list[j] = list[j - gap];
				}
				list[j] = tmp;
			}
		}
	}
	
	public  static void main(String[] args) {
		
		ShellSort sort = new ShellSort();
		sort.testSort();
	}
}
