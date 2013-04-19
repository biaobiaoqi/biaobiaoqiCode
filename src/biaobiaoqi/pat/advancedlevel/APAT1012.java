package biaobiaoqi.pat.advancedlevel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 单单是input和sort就已经超时了。Java不靠谱。
 * @author biaobiaoqi
 *
 */

public class APAT1012 {
	public final static int max = 2005;
	
	public static int[] a ;
	public static int[] c ;
	public static int[] m ;
	public static int[] e ;
	public static int[] aS ;
	public static int[] cS ;
	public static int[] mS ;
	public static int[] eS ;
	
	public static HashMap<Integer, Integer>ar = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer>cr = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer>mr = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer>er = new HashMap<Integer, Integer>();
	
	public static int[] ids = new int[max];
	public static int n;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		a =new int[n+1];
		c =new int[n+1];
		m =new int[n+1];
		e =new int[n+1];
		aS =new int[n+1];
		cS =new int[n+1];
		mS =new int[n+1];
		eS =new int[n+1];
		
		int k = cin.nextInt();
		for (int i=0; i<n; i++) {
			ids[i] = cin.nextInt();
			c[i] = cS[i] = cin.nextInt();
			m[i] = mS[i] = cin.nextInt();
			e[i] = eS[i] = cin.nextInt();
			a[i] = aS[i] = c[i] + m[i] + e[i]; 
		}
		
		Arrays.sort(cS);
		for (int i=max-1; i>=max -n; --i) {
			cr.put(cS[i], max - i);
		}
		Arrays.sort(mS);
		for (int i=max-1; i>=max -n; --i) {
			mr.put(mS[i], max - i);
		}
		Arrays.sort(eS);
		for (int i=max-1; i>=max -n; --i) {
			er.put(eS[i], max - i);
		}
		Arrays.sort(aS);
		for (int i=max-1; i>=max -n; --i) {
			ar.put(aS[i], max - i);
		}
		
		
		
		int id ;
		int aRank,cRank,mRank,eRank;
		for (int i=0; i<k; i++) {
			id = cin.nextInt();
			int j;
			for ( j=0; j<n; j++) {
				if (ids[j] == id) {
					//rank 
					aRank = ar.get(a[j]);
					cRank = cr.get(c[j]);
					mRank = mr.get(m[j]);
					eRank = er.get(e[j]);
					if (aRank <= cRank && aRank <= mRank && aRank <= eRank) {
						System.out.println(aRank + " A");
					}else if (cRank<= aRank  && cRank <= mRank && cRank <= eRank) {
						System.out.println(cRank + " C");
					}else if (mRank<= aRank  && mRank<=cRank   && mRank <= eRank) {
						System.out.println(mRank + " M");
					}else if (eRank<= aRank  && eRank <= mRank && eRank <= cRank) {
						System.out.println(eRank + " E");
					}

					break;
				}
			}
			if (j == n){
				System.out.println("N/A");				
			}
		}
	}
	
}
