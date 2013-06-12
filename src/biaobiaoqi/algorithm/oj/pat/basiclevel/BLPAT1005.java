package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Collections; 
import java.util.HashSet;
import java.util.LinkedList; 
import java.util.Scanner;
import java.util.Set;
 /**
  * 
  * ������(Callatz)�����Ѿ���1001�и������������������Ŀ������΢��Щ���ӡ�

��������֤�����Ȳ����ʱ��Ϊ�˱����ظ����㣬���Լ�¼�µ��ƹ�����������ÿһ�����������n=3������֤��ʱ��������Ҫ����3��5��8��4��2��1�������Ƕ�n=5��8��4��2������֤��ʱ�򣬾Ϳ���ֱ���ж������Ȳ������α��������Ҫ�ظ����㣬��Ϊ��4�����Ѿ�����֤3��ʱ���������ˣ����ǳ�5��8��4��2�Ǳ�3�����ǡ����������ǳ�һ�������е�ĳ����nΪ���ؼ����������n���ܱ������е��������������ǡ�

���ڸ���һϵ�д���֤�����֣�����ֻ��Ҫ��֤���еļ����ؼ������Ϳ��Բ������ظ���֤���µ����֡������������ҳ���Щ�ؼ����֣������Ӵ�С��˳��������ǡ�

�����ʽ��ÿ�������������1��������������1�и���һ��������K(<100)����2�и���K��������ͬ�Ĵ���֤��������n(1<n<=100)��ֵ�����ּ��ÿո������

�����ʽ��ÿ���������������ռһ�У����Ӵ�С��˳������ؼ����֡����ּ���1���ո��������һ�������һ�����ֺ�û�пո�

����������
6
3 5 6 7 8 11
���������
7 6

  *
  * 
  * 1.���ֱ�׵�˼·�Ǵ洢ÿ�����ĸ����������Ⲣ�������Ч�ķ�����
  * 
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
