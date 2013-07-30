/*
 http://pat.zju.edu.cn/contests/pat-a-practise/1010
 */
#include<stdio.h>
#include<string.h>

int flag;
char n1[11], n2[11];
char *objn;
long long target, base;

int value(int n) {
    if (n <= '9')
        return n - '0';
    else
        return n - 'a' + 10;
}

long long targetValue(char n[], long long base){
    long long v = 0;
    int tmp;
    for (int i = 0; n[i] != 0; ++ i) {
        v *= base;
        tmp = value(n[i]);
        if (tmp >= base)
            return -1;
        
        v += tmp;
    }
    return v;
}

int compare(char *n, long long base) {
    long long v = 0;
    int tmp;
    for (int i = 0; n[i] != 0; ++ i) {
        v *= base;
        tmp = value(n[i]);
        v += tmp;
        if (v > target) //防止计算过程总longlong溢出的情况
            return 1;
    }
    
    if (v == target)
        return 0;
    else
        return -1;
}

int main()
{
    scanf("%s %s %d %lld", n1, n2, &flag, &base);
    
    target = flag == 1? targetValue(n1, base) : targetValue(n2, base);
    
    if (target == -1){
        printf("Impossible\n");
        return 0;
    }
    
    //这个题目没交代清楚，1位数的情况。
    if (strlen(n1) == 1 && strlen(n2) == 1 && n1[0] == n2[0] && n1[0] == '1') {
        printf("2\n");
        return 0;
    }else if (strcmp(n1, n2) == 0) {
        printf("%lld\n", base);
        return 0;
    }
    
    if (flag == 1)
        objn = n2;
    else
        objn = n1;
    
    //二分搜索,根据已知radix的值和另一个数字串的每位的数值确定二分的界限。
    long long low = 2, high = target, search;
    for (int i = 0; objn[i] != 0; ++ i) {
        int tmp = value(objn[i]);
        if (tmp >= low)
            low = tmp + 1;
    }
    
    bool possible = false;
    high = high > low ? high : low; //11 b 1 10
    while (low <= high) {
        search = (low + high) / 2;
        int cmp = compare(objn, search);
        if (cmp < 0)
            low = search + 1;
        else if (cmp > 0)
            high = search - 1;
        else {
            possible = true;
            break;
        }
    }
    
    if (possible) printf("%lld\n", search);
    else printf("Impossible\n");
    
    return 0;
}