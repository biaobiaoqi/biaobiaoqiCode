package biaobiaoqi.algorithm.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class pair {
	public int a;
	public double b;

	public pair(int k, double d) {
		this.a = k;
		this.b = d;
	}

	public pair() {
	}
}

public class Playground {
	public static List<pair> list1 = new ArrayList<pair>();
	public static List<pair> list2 = new ArrayList<pair>();
	public static List<pair> res = new ArrayList<pair>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();
		String[] temp1 = str1.split(" ");
		String[] temp2 = str2.split(" ");
		int k1 = Integer.parseInt(temp1[0]);
		int k2 = Integer.parseInt(temp2[0]);

		for (int i = 1; i <= k1 * 2; i = i + 2) {
			int a = Integer.parseInt(temp1[i]);
			double b = Double.parseDouble(temp1[i + 1]);
			pair p = new pair(a, b);
			list1.add(p);
		}
		
		for (int i = 1; i <= k2 * 2; i = i + 2) {
			int a = Integer.parseInt(temp2[i]);
			double b = Double.parseDouble(temp2[i + 1]);
			pair p = new pair(a, b);
			list2.add(p);
		}

		for (int i = 0; i < k1; ++i) {
			pair m = list1.get(i);
			for (int j = 0; j < k2; ++j) {
				pair n = list2.get(j);
				pair tmp = product(m, n);
				addToRes(tmp);
			}
		}
		print(res);
	}

	public static void print(List<pair> list) {
		int count = 0;
		for (int i = 0; i < list.size(); ++i) {
			if(Double.compare(list.get(i).b, 0.0)==0)
				continue;
			//System.out.print(" " + list.get(i).a + " " + list.get(i).b);
			count++;
		}
		
//		if(count==0){
//			System.out.print(0);
//		}
//		else
//		{
			System.out.print(count);
			for (int i = 0; i < res.size(); ++i) {
				if(Double.compare(list.get(i).b, 0.0)==0)
					continue;
				System.out.print(" " + list.get(i).a + " " + deal(list.get(i).b));
//			}
		}
	}

	public static pair product(pair a, pair b) {
		pair re = new pair();
		re.a = a.a + b.a;
		re.b = a.b * b.b;
		re.b = re.b;
		return re;
	}

	public static double deal(double f) {
			return (double) (Math.round(f * 10)) / 10;
	}

	public static void addToRes(pair p) {
		int ex = p.a;
		boolean flag = false;
		int i;
		for (i = 0; i < res.size(); ++i) {
			if (ex == res.get(i).a) {
				flag = true;
				break;
			}
		}
		if (flag) {
			if(Double.compare(res.get(i).b+p.b , 0.0)==0)
				res.remove(i);
			else
			{
				pair newp = new pair(ex, res.get(i).b + p.b);
				res.set(i, newp);
			}
		} else {
			res.add(p);
		}
	}
}