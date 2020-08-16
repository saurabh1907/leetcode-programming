#include<stdio.h>
#include<stdlib.h>
#define MAX 5
static int i = 0;
int G[MAX][MAX];
int n;
int visited[10];
bfs(int v)
{
    int i, front, rear;
    int q[30];
    front = rear = -1;
	printf("%d", v);
	visited[v] = 1;
	rear++;
	front++;
	q[rear] = v;

	while(front <= rear) {
		v = q[front];
		front++;
		for (i = 1; i <= n; i++){
			if (G[v][i] == 1 && !visited[i]){
				printf("%d", i);
				visited[i] = 1;
				rear++;
				q[rear] = i;
        }
	}
    }
}
main()
{
    int i, j, v;
    printf("no of nodes: \n");
    scanf("%d", &n);
    printf("adjacency matrix: \n");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
            scanf("%d",&G[i][j]);
            printf("source: \n");
            scanf("%d", &v);
            bfs(v);
}
