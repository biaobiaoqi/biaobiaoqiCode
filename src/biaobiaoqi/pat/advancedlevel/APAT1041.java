package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;

/**
 * ������Java�ܡ�Java������Ч��̫���ˡ���Cʵ�ֵļ��ɡ�
 * �����������һ�������ǡ�
 * ����һ�ַ������졣����100001�����飬һ���ۼ�����Ĵ�����һ��������˳����һ��hash����hash��˼�롿
 * @author biaobiaoqi
 *
 */
public class APAT1041 {
	
	public static int[] s = new int[10001];
	public static int max = 100001;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = 0;
		for (int i = 1; i <= n; i ++) {
			m = cin.nextInt();
			if (s[m] == 0) {
				s[m] = i;
			}else {
				s[m] = max;
			}
		}
		
		int index = 0;
		for (int i = 1; i < 10001; i++) {
			if (s[i] != 0 && s[i] < max) {
				index = i;
				max = s[i];
			}
		}
		
		if (index == 0) {
			System.out.print("None");
		}else {
			System.out.println(index);
		}
	}
}
