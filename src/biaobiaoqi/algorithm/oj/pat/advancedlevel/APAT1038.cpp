/*
 http://pat.zju.edu.cn/contests/pat-a-practise/1038
 其实就是一道排序题，容易简单的误以为是字典序，其实由于出现了拼接，情况要稍微复杂一点。
 
 F排序规则有两条：
 1.两个字符串做比较时，如果其中一个字符串是另一个字符串的前缀串，则需要将较长字符串的除去前缀串的部分与较短字符串继续按照F规则做比较。比如，321和32，需要拿1和32做比较。又比如323和32比较，第一次迭代拿3和32比较，第二次迭代拿3和2按字典序比较。
 2.其他情况按字典序比较。
 
 推到思路：比较下sample中的数据就知道了。
 
 注意：有一个2分的细节是：如果没有数据，则输出0.
 */

#include<stdio.h>
#include<stdlib.h>
#define MAX 10001
#define LEN 9
char m[MAX][LEN];
int n;
int compare(const void *aa, const void *bb)
{
    char * a = (char *)aa;
    char * b = (char *)bb;
    int ret = 0;
    
    while( !(ret = *a - *b) && *b && *a)
        ++a, ++b;
    
    if (*a && !*b)
        return compare(a, bb);
    if (*b && !*a)
        return compare(aa, b);
    else
        return ret;
}

int main()
{
    scanf("%d", &n);
    for (int i = 0; i != n; ++ i)
        scanf("%s", m[i]);
    
    qsort(m, n, sizeof(char)*9, compare);
    
    bool flag = true;
    for (int i = 0; i != n; ++ i){
        for (int j = 0; m[i][j] != 0; ++ j) {
            if (m[i][j] == '0' && flag)
                continue;
            else {
                flag = false;
                printf("%c", m[i][j]);
            }
        }
    }
    
    if (flag)
        printf("0\n");
    
    return 0;
}

/*
 
 5 32 321 3214 0229 87
 
 22932132143287
 
 ===
 
 2 0001 000
 
 */