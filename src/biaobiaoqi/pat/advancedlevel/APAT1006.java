package biaobiaoqi.pat.advancedlevel;

import java.util.Scanner;

/*
	At the beginning of every day, the first person who signs in the computer room will unlock the door, and the last one who signs out will lock the door. Given the records of signing in's and out's, you are supposed to find the ones who have unlocked and locked the door on that day.
	
	Input Specification:
	
	Each input file contains one test case. Each case contains the records for one day. The case starts with a positive integer M, which is the total number of records, followed by M lines, each in the format:
	
	ID_number Sign_in_time Sign_out_time
	where times are given in the format HH:MM:SS, and ID number is a string with no more than 15 characters.
	
	Output Specification:
	
	For each test case, output in one line the ID numbers of the persons who have unlocked and locked the door on that day. The two ID numbers must be separated by one space.
	
	Note: It is guaranteed that the records are consistent. That is, the sign in time must be earlier than the sign out time for each person, and there are no two persons sign in or out at the same moment.
	
	Sample Input:
	3
	CS301111 15:30:28 17:00:10
	SC3021234 08:00:00 11:25:25
	CS301133 21:45:00 21:58:40
	Sample Output:
	SC3021234 CS301133
 * */

/**
 * 
 * 1.问题模型：设计比较两个HH：MM：SS字符串。Java内建的方式就不错：
 * 	1.1 String的split方法分割字符串
 * 	1.2 Integer.parseInt()方法将字符串转为int值
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
