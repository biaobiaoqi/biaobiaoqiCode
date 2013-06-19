#include <stdio.h>
#include <stdlib.h>
#define max 100005

//http://pat.zju.edu.cn/contests/pat-a-practise/1013

int main() {
	int n, m;
	int tmp;
	int start, end;
	int distance;
	int dis[max];
	scanf("%d",	&n);
	dis[0] = 0;
	for (int i = 1; i <= n; i ++){
		scanf("%d", &tmp);
		dis[i] = dis[i - 1] + tmp;
	}
	scanf("%d", &m);
	for (int i = 0; i != m; i ++){
		scanf("%d%d", &start, &end);
		if (start > end){
			tmp = end;
			end = start;
			start = tmp;
		}
		distance = dis[end - 1] - dis[start - 1];
		if (distance > dis[n] - distance)
			distance = dis[n] - distance;

		printf("%d\n", distance);
	}
	return 0;
}


