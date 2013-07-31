package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;
/**
 * http://pat.zju.edu.cn/contests/pat-a-practise/1005
 * ˮ��
 * 1.ע��Java ���������ԣ�int��תString�ȡ������Ͳ����Լ������߶�int�ı�����˳�������λ�ˡ�
 * 2.hash��˼�롣
 * 
 * @author biaobiaoqi
 *
 */
public class APAT1005 {
	public static String[] mapArray = {"zero", "one", "two", "three", "four", "five", "six", "seven", 
		"eight", "nine"};
	
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		String str = sin.next();
		char ch;
		int sum = 0;
		for (int i = 0; i != str.length(); i ++) {
			ch = str.charAt(i);
			sum += ch - '0';
		}
		
		str = ((Integer)sum).toString();
		for (int i = 0; i != str.length(); i ++ ) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(mapArray[str.charAt(i) - '0']);
		}
		
		
	}
}
