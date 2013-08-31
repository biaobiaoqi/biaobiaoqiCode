#include<stdio.h>
#include<stdlib.h>
int t[1001], a[1001], n;
int compare (void const *a, void const *b)
{
    return *((int *)a) - *((int *)b);
}

int m = 1;
void inorderTrav(int index)
{
    if (index*2 <= n)
        inorderTrav(index*2);
    t[index] = a[m++];
    if (index*2 + 1 <= n)
        inorderTrav(index*2 + 1);
}

int main()
{
    scanf("%d", &n);
    for (int i = 1; i <=n ; ++ i) {
        scanf("%d", &a[i]);
    }
    qsort(a + 1, n, sizeof(int), compare);
    inorderTrav(1);
    
    for (int i = 1; i <= n; i ++) {
        printf("%d", t[i]);
        if (i != n)
            printf(" ");
    }
	
    return 0;
}