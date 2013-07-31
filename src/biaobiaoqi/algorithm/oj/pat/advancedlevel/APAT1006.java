package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.Scanner;

/**
 *http://pat.zju.edu.cn/contests/pat-a-practise/1006 
 * 1.����ģ�ͣ���ƱȽ�����HH��MM��SS�ַ�����Java�ڽ��ķ�ʽ�Ͳ���
 * 	1.1 String��split�����ָ��ַ���
 * 	1.2 Integer.parseInt()�������ַ���תΪintֵ
 * 	
 * 
 * @author biaobiaoqi
 *
 */
public class APAT1006 {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		int n = sin.nextInt();
		String unlockTime = "23:59:59";
		String unlockID = null;
		String lockTime = "00:00:00";
		String lockID = null;
		
		for (int i = 0; i != n ; i ++) {
			String ID = sin.next();
			String arriveTime = sin.next();
			String leaveTime = sin.next();
			
			if (earlierThan(arriveTime, unlockTime)) {
				unlockID = ID;
				unlockTime = arriveTime;
			}
			
			if (earlierThan(lockTime, leaveTime)) {
				lockID = ID;
				lockTime = leaveTime;
			}
		}
		
		System.out.println(unlockID + " " + lockID);
	}
	
	public static boolean earlierThan(String time1, String time2){
		//17:00:10
		int time1Val = getIntValue(time1);
		int time2Val = getIntValue(time2);
		
		return time1Val < time2Val;
	}
	
	public static int getIntValue(String time) {
		String[] strs = time.split(":");
		int sum = Integer.parseInt(strs[0])*3600 + Integer.parseInt(strs[1])*60 + Integer.parseInt(strs[2]);
		return sum;
	}
}
