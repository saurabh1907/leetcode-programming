#include <stdio.h>
#include<stdlib.h>

struct node{
int info;
struct node *left;
struct node *right;
};

struct node * newnode(int data){
struct node * temp=(struct node *)(malloc(sizeof(struct node)));
temp->info=data;
temp->left=temp->right=NULL;
return temp;
}
void inorder(struct node * root){
    if(root==NULL)
        return;
    else{
        inorder(root->left);
        printf("%d\t",root->info);
        inorder(root->right);
        }
}
struct node * searchnode(struct node * node,int item){
    if(node->info==item){
        return node;
    }
    if(node==NULL)
        return node;
    if(node->info>item){
       return searchnode(node->left,item);
      }
    else {
        return searchnode(node->right,item);
    }
}
struct node * insertnode(struct node * node,int item){
    if(node==NULL)
        return newnode(item);
    if(node->info<item)
        node->right=insertnode(node->right,item);
    else if(node->info>item)
        node->left=insertnode(node->left,item);
       return node;
}
struct node * minnode(struct node * node){
    struct node * current=node;
    while(node->left!=NULL)
        current=current->left;
        return current;
}
struct node * deletenode(struct node * node,int item){
    if(node==NULL)
        return node;
    if(node->info>item)
        node->left=deletenode(node->left,item);
    else if(node->info<item)
        node->right=deletenode(node->right,item);
    else{

    if(node->left==NULL){
        struct node * temp=node->right;
        free(node);return temp;
    }
    else if(node->right==NULL){
        struct node *temp=node->left;
        free(node);return temp;
    }
        struct node * temp=minnode(node->right);
        node->info=temp->info;
        node->right=deletenode(node->right,temp->info);
    }
       return node;
}
int main() {
    struct node * root=NULL;
    root=insertnode(root,50);
    root=insertnode(root,30);
    root=insertnode(root,20);
    root=insertnode(root,40);
    root=insertnode(root,70);
    root=insertnode(root,60);
    root=insertnode(root,80);
    inorder(root);
    deletenode(root,40);
    printf("\n");
    inorder(root);

    return 0;
}
