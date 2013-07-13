#include<stdio.h>
#include<queue>
#include<map>
#include<stdlib.h>
#include<string>
using namespace std;

//注意，在17:00前开始服务的都可以得到结果，而不是17:00前结束的

struct person{
	int timeLeft;
	int id;
};

int n, m, k, q;
int t[1001];
int result[1001];
queue< person> windows[21];
int inQueue[11][21];

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

	int timer = 0;
	int pLeft = k;
	while(true){
		//add to in yellow area.
		if (timer < LIMIT)
			for (int i = 0; i != m; ++ i)
				for (int j = 0; j != n; j ++)
					if ( inQueue[i][j] == 0 && pLeft > 0){
						inQueue[i][j] = 1;
						person p;
						p.id = k - (pLeft--) + 1;
						p.timeLeft = t[p.id];
						windows[j].push(p);
					}

		//get the left ones
		int min = 0;
		for (int i = 0; i != n; ++i){
			if (windows[i].size() != 0) {
				if (min == 0 || min > windows[i].front().timeLeft)
					min = windows[i].front().timeLeft;
			}
		}

		timer += min;

		if (min == 0)//end
			break;

		for (int i = 0; i != n ; ++ i){
			if (windows[i].size() != 0){
				windows[i].front().timeLeft -= min;
				if (windows[i].front().timeLeft == 0){
					inQueue[m - 1][i] = 0;
					result[windows[i].front().id] = timer;
					windows[i].pop();

					if (timer >= LIMIT){ //If one hasn't been started before LIMIT, then it's sorry case.
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

/*
2 2 7 5
1 2 6 4 3 534 2
3 4 5 6 7
*/
