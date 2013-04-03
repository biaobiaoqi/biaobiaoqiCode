package biaobiaoqi.practice;

import java.util.Scanner;

/**
 * “答案正确”是自动判题系统给出的最令人欢喜的回复。本题属于PAT的“答案正确”大派送 —— 只要读入的字符串满足下列条件，系统就输出“答案正确”，否则输出“答案错误”。

得到“答案正确”的条件是：

1. 字符串中必须仅有P, A, T这三种字符，不可以包含其它字符；
2. 任意形如 xPATx 的字符串都可以获得“答案正确”，其中 x 或者是空字符串，或者是仅由字母 A 组成的字符串；
3. 如果 aPbTc 是正确的，那么 aPbATca 也是正确的，其中 a, b, c 均或者是空字符串，或者是仅由字母 A 组成的字符串。

现在就请你为PAT写一个自动裁判程序，判定哪些字符串是可以获得“答案正确”的。
输入格式： 每个测试输入包含1个测试用例。第1行给出一个自然数n (<10)，是需要检测的字符串个数。接下来每个字符串占一行，字符串长度不超过100，且不包含空格。

输出格式：每个字符串的检测结果占一行，如果该字符串可以获得“答案正确”，则输出YES，否则输出NO。

输入样例：
8
PAT
PAAT
AAPATAA
AAPAATAAAA
xPATx
PT
Whatever
APAAATAA
输出样例：
YES
YES
YES
YES
NO
NO
NO
NO

 * 
 * 
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
