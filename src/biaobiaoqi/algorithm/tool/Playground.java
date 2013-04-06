package biaobiaoqi.algorithm.tool;

import java.util.LinkedList;


public class Playground {
	public static void main(String[] args) {
		//System.out.print(Integer.parseInt("z", 36));
		
//		NumberFormat nf = NumberFormat.getNumberInstance();
//		String str = nf.format(-99991234);
//		System.out.println(str);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		for (Integer in : list) {
			System.out.println(in);
			
		}

	}
}
