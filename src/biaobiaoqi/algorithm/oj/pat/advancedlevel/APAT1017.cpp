/*
 http://pat.zju.edu.cn/contests/pat-a-practise/1017
 出错：1.建模的逻辑上有了漏洞；2.注意17：00以前开始接收的都能处理完；3.注意while的控制条件。
 
 */
#include<stdio.h>
#include<stdlib.h>
#include<queue>

using namespace::std;

#define MAX      10001

#define START    8*60*60
#define END      17*60*60
struct person {
    int arrive;
    int start;
    int process;
} persons[MAX];

int timer;

int compare(const void * a, const void * b) {
    person *aa = (person *) a;
    person *bb = (person *) b;
    return aa->arrive - bb->arrive;
}

bool operator<(person a, person b)
{
    return  a.process - (timer - a.start)  > b.process - (timer - b.start);
}

int main()
{
    int n,m;
    scanf("%d%d", &n, &m);
    int hour, minute, second;
    for (int i = 1; i <= n; ++i ) {
        scanf("%d:%d:%d %d", &hour, &minute, &second, &persons[i].process);
        persons[i].arrive = hour*60*60 + minute*60 + second;
        persons[i].process *= 60;
    }
    
    qsort(persons + 1, n, sizeof(person), compare);
    
    priority_queue<person> windows;
    int totalTime= 0;
    int count = 0;
    int index = 1;
    timer = START;
    
    while (index <= n) {
        bool breakFlag = false;
        while (windows.size() < m){
            if (persons[index].arrive > END){
                breakFlag = true;
                break;
            }
            //有一种异步的情况处理有问题：如果有空的，但人还没来，而人来的时候，是在另外非空的结束之前。怎么破。
            if (persons[index].arrive > timer)
                persons[index].start = persons[index].arrive;
            else
                persons[index].start = timer;
            
            windows.push(persons[index]);
            
            totalTime += persons[index].start - persons[index].arrive;
            ++ count;
            ++ index;
        }
        if (breakFlag)
            break;
        
        person popPerson = windows.top();
        windows.pop();
        timer  += popPerson.process - (timer - popPerson.start);
    }
    
    printf("%.1f\n", totalTime/(count*60.0));
    
    return 0;
}

/*
 3 1
 07:55:00 16
 08:10:00 16
 09:00:00 20
 */