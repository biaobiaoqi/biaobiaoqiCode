package biaobiaoqi.practice;

import java.util.Collections; 
import java.util.HashSet;
import java.util.LinkedList; 
import java.util.Scanner;
import java.util.Set;
 /**
  * 1.���ֱ�׵�˼·�Ǵ洢ÿ�����ĸ����������Ⲣ�������Ч�ķ�����
  * 2.ע����Ŀ��������1���������Ҫ���ǵ�����Ȼ����������û�п��ǵ���
  * @author biaobiaoqi
  *
  */
public class BLPAT1005 {
	public static Set<Integer> wholeSet = new HashSet<Integer>();
	public static Set<Integer> keySet = new HashSet<Integer>();
	
	public static void main(String args[]) {
		int n = 0;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int num;
		int lastKeyVal;
		
		while (n > 0) {
			n --;
			num = cin.nextInt();
			lastKeyVal = 0;
			
			if (num == 1) {
				keySet.add(1);
			}
			
			while (num != 1) {
				
				if (!wholeSet.contains(num)) {				
					wholeSet.add(num);
					if (lastKeyVal == 0) {
						lastKeyVal = num;	
						keySet.add(num);
					}
				}else {
					if (lastKeyVal != 0) {
						keySet.remove(num);
					}
					break;
				}
				
				
				if (num%2 == 0) {
					num/= 2;
				}else {
					num = (3*num + 1)/2;
				}
			}
		}
		
		LinkedList<Integer> list = new LinkedList<Integer>(keySet);
		Collections.sort(list);
		
		for (int i = list.size() - 1; i >= 0; i --) {
			if (i == 0) {
				System.out.print(list.get(i));
			}else {
				System.out.print(list.get(i) + " ");				
			}
		}		
	}

}
