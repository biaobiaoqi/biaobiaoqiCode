package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.util.Scanner;
/**
 * ���κ�һ����Ȼ��n���������ż������ô��������һ�룻���������������ô��(3n+1)����һ�롣����һֱ��������ȥ�����һ����ĳһ���õ�n=1����������1950���������ѧ�Ҵ���Ϲ�����������룬��˵��ʱҮ³��ѧʦ���붯Ա��ƴ����֤�����ò�ƺ�ɵ����������⣬����ֵ�ѧ��������ѧҵ��һ��ֻ֤(3n+1)������������˵����һ����ı�����������������ӻ�������ѧ���ѧ����еĽ�չ����

���ǽ������Ŀ����֤�������Ȳ��룬���ǶԸ�������һ������1000��������n���򵥵���һ�£���Ҫ���ٲ��������£����ܵõ�n=1��

�����ʽ��ÿ�������������1��������������������Ȼ��n��ֵ��

�����ʽ�������n���㵽1��Ҫ�Ĳ�����

����������
3
���������
5


 * �ύ��ʱ��һֱ�����ط��㡿��ֻҪȥ��package��Ϣ����û�����ˡ�
 * ���������ط��㡿��ԭ���У������׳��쳣��
 * @author biaobiaoqi
 *
 */
public class BLPAT1001 {
	public static int ThreeNPlus1 (int n) {
		int count = 0;
		while (n != 1) {
			count ++ ;
			if (n%2 == 0) {
				n/= 2;
			}else {
				n = (3*n + 1)/2;
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		int n = 0;
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNextInt())
        {
			n = cin.nextInt();
			System.out.println(ThreeNPlus1(n));
        }

	}
	
}
