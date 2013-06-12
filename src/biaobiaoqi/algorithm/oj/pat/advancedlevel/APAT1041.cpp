//
//  APAT1041.cpp
//  APAT1041
//
//  Created by biaobiaoqi  on 13-4-9.
//  Copyright (c) 2013年 biaobiaoqi. All rights reserved.
//

#define MAXCOUNT  100005
#define MAXNUM	  10005
int c[MAXNUM]={0};
int main()
{
    int n;
    
    scanf("%d",&n);
    int i, tmp;
    for(i=1;i<=n;i++){
        scanf("%d",&tmp);
        if (c[tmp] == 0) {
            c[tmp] = i;
        }else {
            c[tmp] = MAXCOUNT;
        }
    }

    int min = MAXCOUNT;
    int minIndex = 0;
    for(i=1;i<MAXNUM;i++){
        if(c[i]!=0 && c[i] < min ){
              min = c[i];
              minIndex = i;
        }
    }
    
    if (minIndex != 0) {
        printf("%d",minIndex);
    }else {
        printf("None");
    }
    return 0;
}
