package biaobiaoqi.algorithm.oj.pat.advancedlevel;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 水题。对密码字符串进行部分hash。
 * TODO 在做replace的时候，或许用StringBuilder会更好一点？
 * */
public class APAT1035 {
	
	
	public static List<String> l = new LinkedList<String>();
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		String str = null;
		for (int i = 0; i != n; i ++) {
			String account = cin.next();
			String password = cin.next();
			
			//filter and replace
			//1 (one) by @, 0 (zero) by %, l by L, and O by o
			if (password.contains("1") || password.contains("0") || password.contains("l") || password.contains("O")) {
				String str1 = password.replaceAll("1", "@");
				String str2 = str1.replaceAll("0", "%");
				String str3 = str2.replaceAll("l", "L");
				String str4 = str3.replaceAll("O", "o");
				l.add(account + " " + str4);
			}
		}
		
		int size = l.size();
		if(size != 0) {
			System.out.println(size);
			for (int i = 0; i != size; i ++) {
				System.out.println(l.get(i));
			}
		}else {
			if (n == 1) {
				System.out.println("There is 1 account and no account is modified");
			}else {
				System.out.println("There are " + n + " accounts and no account is modified");
			}
		}
		
	}
}
