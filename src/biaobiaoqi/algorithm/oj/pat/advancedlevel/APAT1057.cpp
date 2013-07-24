/*
 http://pat.zju.edu.cn/contests/pat-a-practise/1057
 ˼·��stack�Ĳ�������ʵ�֣��ؼ��������ڷ�����λ����
 ������������100000���ڣ����Բ���Ͱ����ķ�ʽ�������״���飬�ö��ֶ�λ����λ����
*/
#include<stdio.h>
#define MAX 100005
#define LOWBIT(x) (x & -x)
int n, top, stack[MAX], tr[MAX];//stack��������ģ��ջ������tr��״����������Ͱ�������������¼�����������λ����

int sum(int x)
{
	int sum = 0;
	while(x){
		sum += tr[x];
		x -= LOWBIT(x);
	}
	return sum;
}

void update(int x, int delta)
{
	while(x < 100001) {
		tr[x] += delta;
		x += LOWBIT(x);
	}
}

int median()
{
	int high = 100000, low = 0, median;
	int target = (!(top%2)) ? top/2: (top + 1)/2;
	while(low <= high) {
		median = (high + low)/2;
		int leftSum = sum(median - 1);
		int medianSum = sum(median);
		if (leftSum < target && medianSum >=  target) //������״����tr[x]��¼����x֮ǰ������ֵ֮�ͣ���С��x��ֵ�ĸ�����������ʱ�������жϸ���ͳ��Щ��ͬ��
			break;
		else if (leftSum >= target)
			high = median;
		else
			low = median;
	}
	return median;
}

int main()
{
	scanf("%d", &n);
	char cmd[15];
	int value;
	while(n --) {
		scanf("%s", cmd);
		if (cmd[1] == 'o') { //pop
			if (top == 0)
				printf("Invalid\n");
			else {
				int value = stack[-- top];
				printf("%d\n", value);
				update(value, -1);
			}
		}else if (cmd[1] == 'u') { //push
			scanf("%d", &value);
			stack[top ++] = value;
			update(value, 1);
		}else { //peekmedian
			if (top == 0)
				printf("Invalid\n");
			else
				printf("%d\n", median());
		}
	}
	return 0;
}
