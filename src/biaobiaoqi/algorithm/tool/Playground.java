package biaobiaoqi.algorithm.tool;


public class Playground {
	
	public static void main(String[] args){
		for (int n = 5; n < 10000; n ++) {
			int max = 1;
			for (int i = 1; i <= n; i ++) {
				if (i > max && 3*i <= n + 2) {
					max = i;
				}
			}
			
			if (max != (n + 2)/3) {
				System.out.println(n + " my:" + max + "   right:" + (n + 2)/3);
			}
			
		}
		

	}
	
}