package biaobiaoqi.algorithm.basics.Tools;

import java.util.ArrayList;
import java.util.Random;

public class Tools {
	public static int defaultListLength = 1000;
	public static Integer[] testArray;
	
	public  void showInProgressArray(Integer[] list){
		System.out.print("In progress: ");
		showArray(list);
		System.out.println();
	}
	
	
	
	public  void showResultArray(Integer[] list, String str){
		System.out.print("Result: [" + str + "] :");
		showArray(list);
		System.out.println();
	}
	
	
	private  void showArray(Integer[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(" "+ list[i]);
		}
	}
	
	public  Integer[] getRandomArray() {
		return this.getRandomArray(defaultListLength);
	}
	
	public  Integer[] getRandomArray(int listLength) {
		Integer[] list = new Integer[listLength];
		Random random = new Random();
		for (int i = 0 ; i != listLength ; i ++ ) {
			Integer integer = random.nextInt(listLength*10);
			if (integer < 0) {
				integer = -integer;
			}
			list[i] = integer;
		}	
		
		System.out.print("test array:");
		showArray(list);
		System.out.println();
		
		return list;
	}
	
	public  Integer[] getTestArray() {
		return this.getTestArray(defaultListLength);
	}
	
	public Integer[] getTestArray(int listLength) {
		if (testArray == null) {
			testArray = getRandomArray(listLength);
		}
		
		return testArray;
	}
}
