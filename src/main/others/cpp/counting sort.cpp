#include <bits/stdc++.h>
void countsort(int *,int *, int , int);
int main(){
    int i,n,k;
    printf("Enter number of elements");
    scanf("%d",&n);
    int *A=(int *)(malloc(sizeof(int)*n));
    for(i=0;i<n;i++){
        scanf("%d",&A[i]);
    }
    int *B=(int *)(malloc(sizeof(int)*n));
    k=10;
    countsort(A,B,k,n);
    for(i=0;i<n;i++)
    printf("%d ",B[i]);

}
void countsort(int *A,int *B,int k,int n){
int i;
int *C=(int *)(malloc(sizeof(int)*k));
for(i=0;i<k;i++)
    C[i]=0;
for(i=0;i<n;i++){
    C[A[i]]=C[A[i]]+1;
}
for(i=0;i<k;i++)
    printf("%d",C[i]);
for(i=1;i<k;i++){
    C[i]=C[i]+C[i-1];
}printf("\n");
for(i=0;i<k;i++)
    printf("%d",C[i]);
    printf("\n");
for(i=n-1;i>=0;i--){
    B[C[A[i]]-1]=A[i];
    C[A[i]]=C[A[i]]-1;
}
}
