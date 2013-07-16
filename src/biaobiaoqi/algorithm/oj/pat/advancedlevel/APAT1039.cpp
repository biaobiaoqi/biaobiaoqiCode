#include<stdio.h>
#include<map>
#include<vector>

/*http://pat.zju.edu.cn/contests/pat-a-practise/1039
 使用最简介的思路：map<string, vector<int> students倒排索引，在没有输出排序的课程列表时最后一个case已经超时；
 将string转化为int，减免了string的匹配过程，还是超时；
 【map本身用红黑树实现，效率并不是特别高，还需要对每组数据进行排序】
 
 AC解法：
 用一个临时的课程vector存储原始输入的数据结构，然后按照课程号从大到小将数据转入倒排索引中。如此实现排序过程。
 其中还做了很多细节优化：比如课程vector的生成动态产生，可以限定其大小；字符串hash值的优化；其他牺牲空间增强时间复杂性的操作。
 
 总结：时间复杂度的突破口在于牺牲空间复杂度！
 */
using namespace::std;
vector<int> st[26*26*26*10];

int n,k;

int getHash(char name[]) {//这个hash方法很关键，用其他的hash方式出现了timeout
    return (name[0]-'A')*26*26*10+(name[1]-'A')*26*10+(name[2]-'A')*10+(name[3]-'0');
}

int main()
{
    scanf("%d%d", &n, &k);
    int course, num, hash;
    char name[5];
    vector<vector<int>> co(k + 1);
    for (int i = 1; i <= k; ++ i) {
        scanf("%d%d", &course, &num);
        for (int j = 1; j <= num; ++ j) {
            scanf("%s", name);
            hash = getHash(name);
            co[course].push_back(hash);
        }
    }
    
    for (int i = 1; i <= k; ++ i){
        long size = co[i].size();
        
        for (int j = 0; j != size; ++ j)
            st[co[i][j]].push_back(i);
    }
    
    for (int i = 1; i <= n; ++ i) {
        scanf("%s", name);
        hash = getHash(name);
        printf("%s %ld", name, st[hash].size());
        for (int j = 0; j != st[hash].size(); ++ j)
            printf(" %d", st[hash][j]);
        printf("\n");
    }
}