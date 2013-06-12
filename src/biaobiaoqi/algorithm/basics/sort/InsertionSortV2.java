package biaobiaoqi.algorithm.basics.sort;
/**
 * ��������
 * 
 * ��ȵ�һ���汾��V2�Ĳ����������ʹ���˼·Ҫ����ࡣ
 * ��һ���汾�У��ж�����λ���Ǵ��ź�������е�С�˿�ʼ��
 * ��V2�汾���ǴӴ�˿�ʼ���ô�������һ��ѭ��������break�������������߼���
 * 
 * @author biaobiaoqi
 *
 */
public class InsertionSortV2 extends BasicSort{
	public void sort(Integer[] list) {
		for (int i = 0; i != list.length; i ++) {
			int j ;
			int tmp = list[i];
			for (j = i; j - 1>= 0 && tmp < list[j - 1]; j --) {
				list[j] = list[j - 1];
			}
			list[j] = tmp;
		}
	}
	
	
	public static void main (String[] args) {
		InsertionSortV2 sort = new InsertionSortV2();
		sort.testSort(20);
	
	}
}
