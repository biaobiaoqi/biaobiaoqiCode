package biaobiaoqi.algorithm.sort;

import biaobiaoqi.algorithm.tool.BenchmarkTools;
import biaobiaoqi.algorithm.tool.Tools;

public class BasicSort {
	public static Tools tools;
	
	public void sort(Integer[] list){
		
	}
	
	public Tools getTools() {
		if (tools == null) {
			//TODO 可以更换运行模式。类似于log4j的不同显示等级
			//tools = new Tools();
			tools = new BenchmarkTools();
		}
		return tools;
	}
	
	public void testSort() {
		tools = getTools();
		
		long beforeTest ;
		long afterTest ;
		
		Integer[] list = tools.getTestArray();
		
		beforeTest = System.currentTimeMillis();
		this.sort(list);
		afterTest = System.currentTimeMillis();
		
		tools.showResultArray(list, this.getClass().getSimpleName() + ":" + (afterTest - beforeTest));
		
	}
	
	
	public void testSort(int listLength) {
		tools = getTools();
		
		long beforeTest ;
		long afterTest ;
		
		Integer[] list = tools.getTestArray(listLength);
		//Integer[] list = DevTools.getTestArray();
		
		
		
		beforeTest = System.currentTimeMillis();
		this.sort(list);
		afterTest = System.currentTimeMillis();
		
		tools.showResultArray(list, this.getClass().getSimpleName() + ":" + (afterTest - beforeTest));
		//DevTools.showResultArray(list, str + ":" + (afterTest - beforeTest));
	}
	
	public void testSort(Integer[] list) {
		tools = getTools();
		
		long beforeTest ;
		long afterTest ;

		
		beforeTest = System.currentTimeMillis();
		this.sort(list);
		afterTest = System.currentTimeMillis();
		
		tools.showResultArray(list, this.getClass().getSimpleName() + ":" + (afterTest - beforeTest));


	}
	
	public static void main (String[] args) {
		System.out.println("This is Basic main()");
	}
	
}
