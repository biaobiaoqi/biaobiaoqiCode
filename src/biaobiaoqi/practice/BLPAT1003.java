package biaobiaoqi.practice;

import java.util.Scanner;

/**
 * 1. 感觉这种题应该有更通用的解法。
 * 2. 利用好Java的字符串处理能力。
 * 
 * @author biaobiaoqi
 *
 */
public class BLPAT1003 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		String str;
		for (int i = 0 ; i < n ; i ++) {
			str = cin.next();
			decideProcess(str);	
			
		}		
	}
	
	public static boolean occurOnce(String str, char ch) {
		
		return (str.lastIndexOf(ch) == str.indexOf(ch)) && (str.lastIndexOf(ch) != -1) ;
 	}
	
	public static boolean allAString(String str) {
		for (int i = 0 ;  i != str.length(); i ++) {
			if (str.charAt(i) != 'A') {
				return false;
			}
		}
		return true;
	}
	
	public static void decideProcess(String str) {
		String result = null;
		int preCount = 0;
		int midCount = 0;
		int postCount = 0;
		
		//最初做的时候，没有判定P和T的相对位置。抛错了。
		if (occurOnce(str, 'P') && occurOnce(str, 'T') && str.indexOf('P') < str.indexOf('T')) {

			String str0 = str.substring(0, str.indexOf('P'));
			String str1 = str.substring(str.indexOf('P') + 1, str.indexOf('T'));
			String str2 = str.substring(str.indexOf('T') + 1, str.length() );

			if (allAString(str0) && allAString(str1) && allAString(str2)) {
				preCount = str0.length();
				midCount = str1.length();
				postCount = str2.length();
				
				if (midCount > 0 && preCount * midCount == postCount) {
					result = "YES";
				}else {
					result = "NO";
				}
				
			}else {
				result = "NO";
			}
			
		}else {
			result = "NO";
		}
		
		System.out.println(result);
	}

	
	public static void worongDecideProcess(String str) {
		String result = null;
		int preCount = 0;
		int middleCount = 0;
		boolean pre = true;
		boolean middle = false;
		int postCount = 0;

		for (int i = 0 ; i != str.length(); i ++ ) {
			char ch = str.charAt(i);
			if (!isLegal(ch) ) {
				result = "NO";
				break;
			}

			if (pre) {
				if (ch == 'A') {
					preCount ++;
				}else if (ch == 'P') {
					pre = false;
					middle = true;
				}else {
					result = "NO";
					break;
				}
			}else if (middle) {
				if (ch == 'A') {
					middleCount ++;
				}else if (ch == 'T' && middleCount >= 1) {
					middle = false;
					postCount = preCount * middleCount;
					if(postCount == 0) {
						result = "YES";
						break;
					}
				}else {
					result = "NO";
					break;
				}
			}else {
				if (ch == 'A') {
					postCount --;
				}
				
				if (i == str.length() - 1) {
					if (postCount == 0) {
						result = "YES";
						break;
					}else {
						result = "NO";
						break;
					}
				}
			}
		}
		
		System.out.println(result);

	}
	public static boolean isLegal(char ch) {
		return ch == 'P' || ch == 'A' || ch == 'T';
	}
}
