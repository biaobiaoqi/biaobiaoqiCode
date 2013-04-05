package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;

/**
 * ��������ᡷP73����ϸ�Ľ��⡣
 * 1.�򵥵�ʹ��ѭ���ᳬʱ��ʹ��DP�ᳬ�ڴ�����
 * 2.��ʵ��������DP�����Ը���������ص㣬���Ƶ�������ʱ�����洢�м�ֵ�����ټ�����̡�
 * 3.�����÷��η����������ʱ�뵽�˴�����η��Σ���������֮ǰ���������Ŀ�����DP������û�м�������˼����ȥ��
 * 4.���ŵ��㷨��Ȼ�Ǳ����������𰸴���󣬻��Ǻ��ɻ�ֱ�����ˡ����ᡷ�ϵĽ��⡣���̼򵥣��������ۻ�����֤���Ǻ��Ͻ�����ģ�Ҳ�õ��ˡ�����˼�롿��
 * @author biaobiaoqi
 */

public class APAT1007 {
	public static int[] a = new int[10010];

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();

		for (int i = 0; i < n ; i++) {
			a[i] = cin.nextInt();
		}
		
		int maxfront = 0;
		int maxtear = 0;
		int max = -1;
		int sum = -1;
		int tear = 0;
		int front = 0;
		
		for (int i = 0; i != n; i ++) {
			if (sum < 0) {
				sum = a[i];
				front = i;
				tear= i;
			}else {
				sum += a[i];
				tear = i;
			}
			
			if (sum > max) {
				max = sum;
				maxfront = front;
				maxtear = tear;
			}
		}
		
		if (max < 0) {
			System.out.println("0 " + a[0] + " " + a[n-1]);
		}else {
			System.out.println(max + " " + a[maxfront] + " " +a[maxtear]);	
		}
	}
}
