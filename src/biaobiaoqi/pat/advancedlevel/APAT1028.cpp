//
//  main.c
//  BBQ
//
//  Created by biaobiaoqi  on 13-4-17.
//  Copyright (c) 2013年 biaobiaoqi. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct Node {
    char id[7];
    char name[9];
    int score;
    
    struct Node* left;
    struct Node* right;
} thisNode;


int c;
int n;
struct Node* root;


int compare(struct Node* n1, struct Node* n2) {
    int result = 0;
    switch (c) {
        case 1:
            result = strcmp(n1->id, n2->id);
            break;
        case 2:
            result = strcmp(n1->name, n2->name);
            if (result == 0) result = strcmp(n1->id, n2->id);
            break;
            
        case 3:
            if (n1->score == n2->score) result = strcmp(n1->id, n2->id);
            else result = n1->score < n2->score? -1: 1;
        default:
            break;
    }
    return result;
}


void print(struct Node* node){
    if (node){
        print(node->left);
        printf("%s %s %d\n", node->id, node->name, node->score);
        print(node->right);
    }
}

struct Node* insertNode(struct Node* p, struct Node* n) {
    if (p) {
        int c = compare(p, n);
        if (c < 0) {
            p->right = insertNode(p->right, n);
        }else {
            p->left = insertNode(p->left, n);
        }
        return p;
    }else {
        return n;
    }
}


int main(int argc, const char * agv[])
{
    scanf("%d%d", &n, &c);
    struct Node* node;
    while (n-- > 0) {
        node = (struct Node*) malloc(sizeof(thisNode));
        memset(node, 0, sizeof(thisNode));
        scanf("%s%s%d", node->id, node->name, &node->score);
        
        root = insertNode(root, node);
    }
    
    print(root);
    return 0;
}



