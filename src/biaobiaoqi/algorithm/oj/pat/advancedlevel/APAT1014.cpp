#include<stdio.h>
#include<queue>
#include<stdlib.h>
using namespace std;

//ע�⣬��17:00ǰ��ʼ����Ķ����Եõ������������17:00ǰ������

struct person{
	int id, timeLeft; //����Ҫ�೤ʱ��Ĵ����������
};

int n, m, k, q;
int t[1001];
int result[1001];
queue< person> windows[21];//��queueģ�ⴰ��

#define LIMIT 60*9

int main()
{
	scanf("%d%d%d%d", &n, &m, &k, &q);
	for (int i = 1; i <= k; ++i)
		scanf("%d", &t[i]);

	for (int i = 1; i <= n; ++i){
		queue<person> pq;
		windows[i] = pq;
	}

	int timer = 0;//ȫ��ʱ��
	int pLeft = k;//��û�н�������ڵĵȴ����������
	while(true){
		if (timer < LIMIT)
			for (int i = 0; i != m; ++ i) { //�����ĸ�������̣����ͬ�ȶ��г�����ѡ�����С���ڵ�ԭ�򲹽�������Ⱥ����
				for (int j = 0; j != n; j ++)
					if (windows[j].size() == i && pLeft > 0) {
						person p;
						p.id = k - (pLeft--) + 1;
						p.timeLeft = t[p.id];
						windows[j].push(p); //�����˼�������С�
					}
			}

		//�ҵ����������У���һ���뿪���ڵ�ʱ��
		int min = 0;
		for (int i = 0; i != n; ++i){
			if (windows[i].size() != 0) {
				if (min == 0 || min > windows[i].front().timeLeft)
					min = windows[i].front().timeLeft;
			}
		}

		timer += min;

		if (min == 0)//���û����һ���뿪���ڵ�ʱ�䣬����������˶�������ϡ�
			break;

		for (int i = 0; i != n ; ++ i){
			if (windows[i].size() != 0){
				windows[i].front().timeLeft -= min;
				if (windows[i].front().timeLeft == 0){ //��timerʱ����뿪���ڵ����
					result[windows[i].front().id] = timer; //��¼������˽��������ʱ��
					windows[i].pop();

					if (timer >= LIMIT){ //����LIMITʱ���֮�󣬻�û���ܴ�����˶�����ճ����У����������ˡ�
						while(!windows[i].empty())
							windows[i].pop();
					}

				}
			}
		}
	}

	int query;
	for (int i = 0; i !=q; ++i){
		scanf("%d", &query);
		if (result[query] == 0)
			printf("Sorry\n");
		else{
			int tmp = result[query];
			printf("%02d:%02d\n", 8 + tmp/60, tmp%60);
		}
	}
	return 0;
}
