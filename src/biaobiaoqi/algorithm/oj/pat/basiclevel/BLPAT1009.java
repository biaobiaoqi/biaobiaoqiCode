package biaobiaoqi.algorithm.oj.pat.basiclevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 
 * ����һ��Ӣ�Ҫ�����д���򣬽��������е��ʵ�˳��ߵ������

�����ʽ�������������һ��������������һ���ڸ����ܳ��Ȳ�����80���ַ������ַ��������ɵ��ʺ����ɿո���ɣ����е�������Ӣ����ĸ����Сд�����֣���ɵ��ַ���������֮����1���ո�ֿ������뱣֤����ĩβû�ж���Ŀո�

�����ʽ��ÿ���������������ռһ�У���������ľ��ӡ�

����������
Hello World Here I Come
���������
Come I Here World Hello
 * 
 * 
 * 
 * 1.��Ҫע��reader���÷���JAVA ��IO
 * 2.����String��split�����������������
 * @author biaobiaoqi
 *
 */
public class BLPAT1009 {
	public static void main(String args[]) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String string = bReader.readLine();
		String[] strings = string.split(" ");
		for (int i = strings.length - 1; i >= 0 ;  i --) {
			System.out.print(strings[i]);
			if (i != 0) {
				System.out.print(" ");
			}
		}
	}
}
