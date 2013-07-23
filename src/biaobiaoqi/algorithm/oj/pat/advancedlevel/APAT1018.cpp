/*
 http://pat.zju.edu.cn/contests/pat-a-practise/1018
 ˼·��
	1.ʹ��Dijkstra�ҵ����·��������ע���¼ÿ���ڵ������·���еġ����С�ǰ���ڵ㣻
	2.ʹ��DFS�ķ������õ����е����·����
	3.����ÿ�����·���Ĵ����ʹ��صĳ���������
 ע�⣺
	1.DFS�ķ��������������·���ķ�����common sense����Ҫ���ա�
	2.Dij�Ķ��Ż�����û�����պã�д���ˣ�debug�˺ܾá�
	3.����֤��Dij�㷨�����У���¼ÿ���ڵ�Ĵ���ʹ��������������޷������ģ���n����복����Ϊsend[n]�����س�����Ϊback[n]��֤������n������·������һ���ڵ�n+1��send[n+1]��back[n+1]���޷�ͨ��send[n] back[n]������ģ��ٳ�������
	��ˣ������ȵó����·������������㡣
*/
#include<stdio.h>
#include<vector>
#include<map>
using namespace::std;
#define MAX 501
#define MAX_INT ((unsigned)(-1) >> 1)

long long adj[MAX][MAX];
int visit[MAX], dist[MAX];
vector<int> prevlist[MAX];
int c[MAX];
int cm, n, dest, m;
vector<vector<int>> result;
struct distNode{
	int node;
	distNode(int a){ node = a; }
};

bool operator <(const distNode &a, const distNode &b)
{
	return dist[a.node] > dist[b.node];
}

void dijkstra()
{
	for (int i = 1; i <= n; ++ i)
		dist[i] = MAX_INT;

	while(true) {
		int minDist = MAX_INT;
		int selectedNode = -1;
		for (int i = 0; i != n; ++ i) {
			if (!visit[i] && minDist > dist[i]) {
				selectedNode = i;
				minDist = dist[i];
			}
		}
		if (selectedNode == -1) break;
		visit[selectedNode] = 1;

		for (int i = 0; i <= n; ++ i)
			if (adj[selectedNode][i] && i != selectedNode && !visit[i] )
				if (dist[selectedNode] + adj[selectedNode][i] == dist[i])
					prevlist[i].push_back(selectedNode);
				else if (dist[selectedNode] + adj[selectedNode][i] < dist[i]) {
					dist[i] = dist[selectedNode] + adj[selectedNode][i];
					prevlist[i].clear();
					prevlist[i].push_back(selectedNode);
				}
	}
}

void dfs(int d, vector<int> *path)
{
	path->push_back(d);
	if (d == 0)
		result.push_back(*path);
	else
		for (int i = 0; i != prevlist[d].size(); ++ i)
			dfs(prevlist[d][i], path);
	path->pop_back();
}

int main()
{
	scanf("%d%d%d%d", &cm, &n, &dest, &m);
	for (int i = 1; i <= n; ++ i) scanf("%d", &c[i]);
	for (int i =0; i != m; ++ i) {
		int a, b;
		long long c;
		scanf("%d %d %lld", &a, &b, &c);
		adj[a][b] = adj[b][a] = c;
	}

	dijkstra();
	vector<int> path;
	dfs(dest, &path);

	int minSend = MAX_INT, minBack = MAX_INT, min = MAX_INT;
	for (int j = 0; j != result.size(); ++ j){
		int send = 0, back = 0;
		for (int i = result[j].size() - 2; i >= 0 ; -- i) {
			int tmp = cm/2 - c[result[j][i]];
			if (tmp < 0)
				back += -tmp;
			else if (tmp > back) {
				send += tmp - back;
				back = 0;
			}else
				back -= tmp;
		}

		if (minSend > send ||( minSend == send && minBack > back)){
			minBack = back;
			minSend = send;
			min = j;
		}
	}

	printf("%d 0", minSend);
	for (int i =  result[min].size() - 2; i >= 0; -- i)
		printf("->%d",result[min][i]);
	printf(" %d\n", minBack);

	return 0;
}

/*

10 3 3 5
6 7 0
0 1 1
0 2 1
0 3 3
1 3 1
2 3 1

3 0->2->3 0
*/
