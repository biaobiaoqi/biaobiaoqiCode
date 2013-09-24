package biaobiaoqi.algorithm.basics.sort;

public class MergeSort extends BasicSort {
	public void sort(Integer[] list) {
		if (list.length == 0) {
			System.out.println("数组为空！");
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
		
		// 这块循环代码，之前的实现使用的是，外层while，内层两个并列的while。如此容易出现index越界错误，增加了复杂度。
		// 这个实现，将循环，越界判断都放在了外部，内部只实现比较、赋值逻辑。耦合性更强，不容易出错！
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

		// numberic 用个不自然
		for (int i = leftPos; i <= rightEnd; i ++) {
			list[i] = tmpList[i];
		}

	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		sort.testSort(15);
	}
}