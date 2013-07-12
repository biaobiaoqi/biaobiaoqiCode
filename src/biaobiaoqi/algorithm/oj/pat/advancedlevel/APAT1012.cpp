#include<stdio.h>
#include<map>
#include<stdlib.h>
#include<string>

/*
 *WA了很多次。
 *有一处坑：同等分数的名次。比如1,2,2,4
 *有一个问题：这份代码写的太冗余，容易造成维护代码时的不一致！！！
 * */

using namespace std;

#define MAX 2001
int m,n;

struct student {
	char id[8];
	int c;
	int m;
	int e;
	int a;
} st[MAX];

struct finalRank {
	int rank;
	char item;
};

int compareC(const void *a, const void *b)
{
	return ((student *)b)->c  - ((student *)a)->c;
}

int compareM(const void *a, const void *b)
{
	return ((student *)b)->m - ((student *)a)->m;
}

int compareE(const void *a, const void *b)
{
	return ((student *)b)->e - ((student *)a)->e;
}

int compareA(const void *a, const void *b)
{
	return ((student *)b)->a - ((student *)a)->a;
}

int main()
{
	map<string,  finalRank> result;

	scanf("%d%d", &n, &m);
	for (int i = 0; i != n; ++i){
		scanf("%s%d%d%d", &st[i].id, &st[i].c, &st[i].m, &st[i].e);
		st[i].a = st[i].c + st[i].m + st[i].e;
		finalRank fr = {0, 0};
		result[st[i].id] = fr;
	}

	int currentRank = 1;
	int delta = 0;
	qsort(st, n, sizeof(student), compareA);
	for (int i = 0; i != n; ++i ){
		if (i != 0 && compareA(&st[i - 1], &st[i]) != 0 ){
			currentRank += delta;
			delta = 1;
		}else
			delta ++;

		result[st[i].id].item = 'A';
		result[st[i].id].rank = currentRank;
	}

	currentRank = 1;
	delta = 0;
	qsort(st, n, sizeof(student), compareC);
	for (int i = 0; i != n; ++i ){
		if (i != 0 && compareC(&st[i - 1], &st[i]) != 0 ){
			currentRank += delta;
			delta = 1;
		}else
			delta ++;

		if (result[st[i].id].rank > currentRank){
			result[st[i].id].item = 'C';
			result[st[i].id].rank = currentRank;
		}
	}

	currentRank = 1;
	delta = 0;
	qsort(st, n, sizeof(student), compareM);
	for (int i = 0; i != n; ++i ){
		if (i != 0 && compareM(&st[i - 1], &st[i]) != 0 ){
			currentRank += delta;
			delta = 1;
		}else
			delta ++;

		if (result[st[i].id].rank > currentRank){
			result[st[i].id].item = 'M';
			result[st[i].id].rank = currentRank;
		}
	}

	currentRank = 1;
	delta = 0;
	qsort(st, n, sizeof(student), compareE);
	for (int i = 0; i != n; ++i ){
		if (i != 0 && compareE(&st[i - 1], &st[i]) != 0 ){
			currentRank += delta;
			delta = 1;
		}else
			delta ++;

		if (result[st[i].id].rank > currentRank){
			result[st[i].id].item = 'E';
			result[st[i].id].rank = currentRank;
		}
	}

	char name[7];
	for (int i = 0; i != m; ++i ){
		scanf("%s", &name );
		if (result.find(name) == result.end())
			printf("N/A\n");
		else
			printf("%d %c\n", result[name].rank, result[name].item);
	}

	return 0;
}

