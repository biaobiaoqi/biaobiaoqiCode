package biaobiaoqi.algorithm.sort;

public class MergeSort extends BasicSort{
	public void sort(Integer[] list){
		if (list.length == 0) {
			System.out.println("����Ϊ�գ�");
		}else {
			Integer[] tmpList = new Integer[list.length];
			mergeSort(list, 0, list.length - 1, tmpList);
		}
	}
	
	public void mergeSort(Integer[] list, int leftPos, int rightPos, Integer[] tmpList) {
		if (leftPos < rightPos) {
			int center = (leftPos + rightPos) / 2 ;
			mergeSort(list, leftPos, center, tmpList);
			mergeSort(list, center + 1, rightPos, tmpList);
			merge(list, leftPos, center + 1, rightPos, tmpList);
		}
	}
	
	public void merge(Integer[] list, int leftPos, int rightPos, int rightEnd, Integer[] tmpList) {
		int leftEnd = rightPos -1;
		int numberic = rightEnd - leftPos + 1;
		int index = leftPos ;
		
		//���ѭ�����룬֮ǰ��ʵ��ʹ�õ��ǣ����while���ڲ��������е�while��������׳���indexԽ����������˸��Ӷȡ�
		//���ʵ�֣���ѭ����Խ���ж϶��������ⲿ���ڲ�ֻʵ�ֱȽϡ���ֵ�߼�������Ը�ǿ�������׳���
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (list[leftPos] <= list[rightPos]) {
				tmpList[index ++] = list[leftPos ++];
			}else {
				tmpList[index ++] = list[rightPos ++];
			}
		}
		
		while (leftPos <= leftEnd) {
			tmpList[index ++] = list[leftPos++];
		}
		while (rightPos <= rightEnd) {
			tmpList[index ++] = list[rightPos++];
		}
		
		//numberic �ø�����Ȼ
		for (; numberic > 0; numberic --) {
			list[rightEnd] = tmpList[rightEnd];
			rightEnd --;
		}
		
	}
	
	public static void main (String[] args) {
		MergeSort sort = new MergeSort();
		sort.testSort(15);
	}
}