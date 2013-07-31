/*
 http://pat.zju.edu.cn/contests/pat-a-practise/1017
 ����1.��ģ���߼�������©����2.ע��17��00��ǰ��ʼ���յĶ��ܴ����ꣻ3.ע��while�Ŀ���������
 
 */
#include<stdio.h>
#include<stdlib.h>
#include<queue>
using namespace std;

#define MAX      10001
#define START    8*60*60
#define END      17*60*60

struct person {
    int arrive, start, process;
} persons[MAX];

int compare(const void * a, const void * b) {
    person *aa = (person *) a;
    person *bb = (person *) b;
    return aa->arrive - bb->arrive;
}

bool operator<(person a, person b) //�������ȶ����еıȽϣ�ĳ�˽��������ʱ���뵱ǰʱ�̱ȽϽ�������ǰ�š�
{
    return  a.start + a.process  > b.start + b.process;
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
    int timer = START;
    
    while (index <= n) {
        bool breakFlag = false;
        while (windows.size() < m){ //��������ȴ����˷ŵ�������������
            if (persons[index].arrive > END){
                breakFlag = true;
                break;
            }

            if (persons[index].arrive > timer) //�����ǰʱ�̣���һ���˻�û�е�����ô���Ŀ�ʼʱ������Ϊ�����ʱ��
                persons[index].start = persons[index].arrive;
            else
                persons[index].start = timer;
            
            windows.push(persons[index]);
            
            totalTime += persons[index].start - persons[index].arrive;
            ++ count;
            ++ index;
        }

		if (breakFlag)//����ֻ��Ҫ����ȴ�ʱ�䣬���Եõ������˵Ŀ�ʼʱ��󣬼�������ѭ��������ս��
            break;
        
        person popPerson = windows.top();
        windows.pop();
        timer = popPerson.process + popPerson.start;
    }
    
    printf("%.1f\n", totalTime/(count*60.0));
    
    return 0;
}
