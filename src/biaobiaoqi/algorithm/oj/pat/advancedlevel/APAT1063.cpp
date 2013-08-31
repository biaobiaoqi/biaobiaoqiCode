#include<stdio.h>
#include<algorithm>
using namespace std;
int n, m, k;
int ar[51][10001];

int getnc(int a, int b)
{
    int c1 = ar[a][0], c2 = ar[b][0];
    int i = 1, j = 1;
    int ret = 0;
    
    while(i <= c1 && j <= c2) {
        if (ar[a][i] < ar[b][j]) {
            i ++;
        } else if(ar[a][i] == ar[b][j]) {
            i ++;
            j ++;
            ret ++;
        } else {
            j ++;
        }
    }
    return ret;
}

int getnt(int a, int b)
{
    int ret = 0;
    int c1 = ar[a][0], c2 = ar[b][0];
    int i = 1, j = 1;
    
    while (i <= c1 || j <= c2) {
        ret ++;
        if (i <= c1 && j > c2) {
            i ++;
        }else if (i > c1 && j <= c2) {
            j ++;
        }else {
            if (ar[a][i] == ar[b][j]) {
                i ++;
                j ++;
            }else if (ar[a][i] < ar[b][j]) {
                i ++;
            }else {
                j ++;
            }
        }
    }
    return ret;
}

int main()
{
    scanf("%d", &n);
    for (int i = 1; i <= n; i ++) {
        scanf ("%d", &m);
        ar[i][0] = m;
        for (int j = 1; j <= m; j ++) {
            scanf("%d", &ar[i][j]);
        }
        sort(ar[i]+1, ar[i]+m+1);
        int index = 1;
        
        for (int j = 1; j <= m; j ++) {
            ar[i][index ++] = ar[i][j];
            while (j <= m && ar[i][j] == ar[i][j + 1])
                j ++;
        }
        ar[i][0] = index - 1;
    }
    
    scanf("%d", &k);
    for (int i = 0; i != k; ++ i) {
        int a, b;
        scanf("%d %d", &a, &b);
        printf("%.1lf%%\n", getnc(a,b)*100.0/getnt(a,b));
    }
    
    return 0;
}