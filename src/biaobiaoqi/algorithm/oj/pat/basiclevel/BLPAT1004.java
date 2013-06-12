package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;

/**
 * ����n��ѧ����������ѧ�š��ɼ����ֱ�����ɼ���ߺͳɼ����ѧ����������ѧ�š�

�����ʽ��ÿ�������������1��������������ʽΪ

  ��1�У�������n
  ��2�У���1��ѧ�������� ѧ�� �ɼ�
  ��3�У���2��ѧ�������� ѧ�� �ɼ�
  ... ... ...
  ��n+1�У���n��ѧ�������� ѧ�� �ɼ�
����������ѧ�ž�Ϊ������10���ַ����ַ������ɼ�Ϊ0��100֮���һ�����������ﱣ֤��һ�����������û������ѧ���ĳɼ�����ͬ�ġ�
�����ʽ����ÿ�������������2�У���1���ǳɼ����ѧ����������ѧ�ţ���2���ǳɼ����ѧ����������ѧ�ţ��ַ�������1�ո�

����������
3
Joe Math990112 89
Mike CS991301 100
Mary EE990830 95
���������
Mike CS991301
Joe Math990112
 * 
 * �����Ŀ���޼���������
 * @author biaobiaoqi
 *
 */
public class BLPAT1004 {
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		String highestName = null, highestNo = null;
		String lowestName = null, lowestNo = null;
		int highestScore = 0, lowestScore = 100, score;
		String name, no;
		for (int i = 0 ; i < n ; i ++) {
			name = cin.next();
			no = cin.next();
			score = cin.nextInt();
			if (score < lowestScore) {
				lowestScore = score;
				lowestName = name;
				lowestNo = no;
			}
			
			if (score > highestScore) {
				highestName = name;
				highestNo = no;
				highestScore = score;
			}
		}	

		System.out.println(highestName + " " + highestNo);
		System.out.println(lowestName + " " + lowestNo);
	}
}
