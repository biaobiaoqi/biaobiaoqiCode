/*http://pat.zju.edu.cn/contests/pat-a-practise/1049
�����֮�����н��⡣һ�����ط�������Ŀ��
���������ʱ�����ֽ���ķ����뿪ȥ�ˣ��߽�������ͬ��
1.˼·������˼·���չ���˶��������ڹ��������У������ݵĹ����з���������ÿ��λ�ö���������ִ���������ϸϸƷζ��
2.���ɣ����ֺ�common sense�İ�λ����ʽ��Ҫ���ա�����r*=10������
3.ע�⣺������Ĺ�ʽ�����ɣ���Ҫ�ڱ߽�ֵ����ͬ����½�����֤��
*/
#include<stdio.h>

int main()
{
	int n;
	long long sum = 0;
	scanf("%d", &n);

	int left, current, right;
	int r = 1;
	while (n/r) {
		//printf("test:%d sum:%ld\n",tmp, sum);
		left = n/(r*10);
		current = (n/r)%10;
		right  = n - (n/r)*r;

		//printf("left:%d current:%d right:%d\n", left, current, right);
		if (current == 1) {
			sum += right + 1 + left * r;
		}else if (current > 1 ) {
			sum += (left + 1)*r;
		}else {
			sum += left * r;
		}

		r *= 10;
	}

	printf("%ld\n", sum);
	//getchar();
}
