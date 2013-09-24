package biaobiaoqi.algorithm.basics.sort;

public class MergeSort extends BasicSort {
	public void sort(Integer[] list) {
		if (list.length == 0) {
			System.out.println("����Ϊ�գ�");
		} else {
			Integer[] tmpList = new Integer[list.length];
			mergeSort(list, 0, list.length - 1, tmpList);
		}
	}

	public void mergeSort(Integer[] list, int leftPos, int rightPos,
			Integer[] tmpList) {
		if (leftPos >= rightPos)
			return;

		int center = (leftPos + rightPos) / 2;
		mergeSort(list, leftPos, center, tmpList);
		mergeSort(list, center + 1, rightPos, tmpList);
		merge(list, leftPos, center, rightPos, tmpList);
	}

	public void merge(Integer[] list, int leftPos, int leftEnd, int rightEnd,
			Integer[] tmpList) {
		int leftIndex  = leftPos;
		int rightIndex = leftEnd + 1;
		int index = leftIndex;
		
		// ���ѭ�����룬֮ǰ��ʵ��ʹ�õ��ǣ����while���ڲ��������е�while��������׳���indexԽ����������˸��Ӷȡ�
		// ���ʵ�֣���ѭ����Խ���ж϶��������ⲿ���ڲ�ֻʵ�ֱȽϡ���ֵ�߼�������Ը�ǿ�������׳���
		while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
			if (list[leftIndex] <= list[rightIndex]) {
				tmpList[index++] = list[leftIndex++];
			} else {
				tmpList[index++] = list[rightIndex++];
			}
		}

		while (leftIndex <= leftEnd) {
			tmpList[index++] = list[leftIndex++];
		}
		while (rightIndex <= rightEnd) {
			tmpList[index++] = list[rightIndex++];
		}

		// numberic �ø�����Ȼ
		for (int i = leftPos; i <= rightEnd; i ++) {
			list[i] = tmpList[i];
		}

	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		sort.testSort(15);
	}
}