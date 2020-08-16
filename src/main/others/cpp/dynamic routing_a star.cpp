#include<stdlib.h>
#include<stdio.h>
#include<limits.h>
#include<time.h>
#include<map>
#include<vector>
#include<list>
#include<iostream>
#define V 21
#define beta 0.2
#define alpha 0.01
struct node
{
    int id;
    float g_x, h_x, f_x;
    int parent;
};

int distance[V][V] = {0};
int speed[V][V] = {0};
float eculidean[V][V]= {0};
int traffic[V][V]= {0};

int count, path[V],finalpath[V];
std::vector<int> neighbour[V];
std::list<struct node> openlist;
std::list<struct node> closedlist;


void trafficgen()
{
    int i,j;
    for(i=0; i<V; i++)
    {
        for(j=i; j<V; j++)
        {
            if(distance[i][j]>0)
            {
                traffic[i][j]= traffic[j][i]= rand()%10+1;
            }
        }

    }
}


int eculidean_dist()
{
    int u,v;
    float w;
    FILE *file;
    if ((file = fopen("eculidean2.csv", "r")) == NULL)
    {
        fprintf(stdout, "Error: Can't open file 1!\n");
        return -1;
    }
    while(!feof(file))
    {
        fscanf(file, "%d,%d,%f", &u, &v, &w);
        eculidean[u][v] = w;
        eculidean[v][u] = w;
    }
    fclose(file);
    return 0;
}

/*void initialize()
{
        trafficgen();

    int i;
    count=0;
    for(i=0;i<V;i++)
    {
            cost[i]=INT_MAX;
            parent[i]=-1;
            path[i]=-1;
            //if(!traversed[i])
                visited[i]=0;
    }
} */

int choosemin(std::list<struct node> openlist)
  {
         int min = INT_MAX, min_index;

      std::list<struct node>::iterator it;
      for(it=openlist.begin();it!=openlist.end();it++)
        {
            if((*it).f_x<min)
                {
            min=(*it).f_x;
            min_index=(*it).id;
            }
        }
        return min_index;
  }

  std::list<struct node>::iterator findbyid(std::list<struct node> givenlist,int id){
  std::list<struct node>::iterator it;
  for(it=givenlist.begin();it!=givenlist.end();it++){
    if(it->id==id)
        return it;
  }
  return givenlist.end();
  }


std::list<struct node>::iterator isopenlist(int id)
  {
      std::list<struct node>::iterator findIter = findbyid(openlist, id);
  return findIter;
  }

  std::list<struct node>::iterator isclosedlist(int id)
  {
       std::list<struct node>::iterator findIter = findbyid(openlist, id);
 return findIter;
  }

/*void storepath(int destn)
{
    if(destn==-1){
        return;
    }
    storepath(parent[destn]);
    path[count++]=destn;
    //printf("store min");
}
    void printpath()
    {   int i;
        for(i=0;path[i]>=0;++i){
            printf("->%d ",path[i]);
        }
        printf("\n");
    }

double next_hop(int source,int hop_count, int destn){
    if(hop_count==0){
     //printf("hop 0");
        return 0;
    }
 double min = INT_MAX, newcost = INT_MAX;
 int min_index,ii;
 int num_neighbours=neighbour[source].size();
 for(ii=0; ii<num_neighbours; ++ii)
    {   newcost = (distance[source][neighbour[source][ii]]*1.0)/speed[source][neighbour[source][ii]] + beta * traffic[source][neighbour[source][ii]] +
                alpha * eculidean[source][destn] + next_hop(neighbour[source][ii], hop_count - 1,destn);
        if(!visited[neighbour[source][ii]] && newcost<=min)
        {
            min= newcost;
            min_index= neighbour[source][ii];
        }
    }
    return min;
} */
 void printpath(){
 std::list<struct node>::iterator it;
 for(it=openlist.begin();it!=openlist.end();it++){
    printf("->%d",it->id);
 }
 }

int pathfind(int src,int destn)
{
    int ii,id;
    float g_x,f_x,h_x;
    trafficgen();

    std::list<struct node>::iterator it;
    openlist.push_back(node());
    it=openlist.begin();
    it->id=src;
    it->g_x=0;
    it->h_x=alpha * eculidean[it->id][destn];
    it->f_x= it->g_x + it->h_x;
    it->parent=NULL;
    while(!openlist.empty())
        {
    id=choosemin(openlist);
    //printf("%d\t",id);
    if(id==destn)
        break;
    std::list<struct node>::iterator id_iter = findbyid(openlist, id);
    //printpath();
    printpath();
    printf("this was open list \n");
    openlist.erase(id_iter);
    printpath();printf("after erase\n");
    closedlist.push_back(*id_iter);
    int num_neighbours=neighbour[id].size();

    for(ii=0; ii<num_neighbours; ++ii)
    {
               g_x= id_iter->g_x + (distance[id][neighbour[id][ii]]*1.0)/speed[id][neighbour[id][ii]] + beta * traffic[id][neighbour[id][ii]];
               h_x= alpha * eculidean[id][destn];
               f_x= g_x + h_x;

            std::list<struct node>::iterator olditer1=isopenlist(neighbour[id][ii]);
            std::list<struct node>::iterator olditer2=isclosedlist(neighbour[id][ii]);

        if(olditer1 !=openlist.end())
        {//printf("inside openlist");
         if(f_x < olditer1->f_x)
            {
                olditer1->g_x=g_x;
                olditer1->h_x=h_x;
                olditer1->f_x=f_x;
                olditer1->parent=id;
            }
        }
        else if(isclosedlist(neighbour[id][ii])!=openlist.end())
        {   printf("inside closedlist");
            //compare cost old and new if old is less skip
            if(f_x < olditer2->f_x)
            {
                olditer2->g_x=g_x;
                olditer2->h_x=h_x;
                olditer2->f_x=f_x;
                olditer2->parent=id;
            }
        }
        else {
                printf("no list");
                struct node newnode;
               newnode.g_x= g_x;
               newnode.h_x= h_x;
               newnode.f_x= f_x;
               newnode.parent=id;
            openlist.push_back(newnode);
        }
        }
        closedlist.push_back(*id_iter);
        }
     //storepath(destn);
}

    int main()
    {
        int src,destn;
        int i=1,j,u,v,w,q;
        srand (time(NULL));
        FILE *file;
        if ((file = fopen("inputnew2.csv", "r")) == NULL)
        {
            fprintf(stdout, "Error: Can't open file !\n");
            return -1;
        }
        while(!feof(file))
        {
            fscanf(file, "%d,%d,%d,%d", &u, &v, &w,&q);
            distance[u][v] = w;
            distance[v][u] = w;
            speed[u][v] = q;
            speed[v][u] = q;
            neighbour[u].push_back(v);
            neighbour[v].push_back(u);
        }
        fclose(file);


        printf("\nEnter src ->");
        scanf("%d",&src);
        printf("\nEnter destination ->");
        scanf("%d",&destn);
        printf("\n");
       // finalpath[0]=src;
        eculidean_dist();
        //while(src!=destn){
        pathfind(src,destn);
        //src=path[1];
        //finalpath[i++]=src;
        printpath();
        //}

        printf("Goal reached\nFinal path is");
        /*for(j=0;finalpath[j]!=0;j++)
        printf("-> %d",finalpath[j]);
        */return 0;
    }

