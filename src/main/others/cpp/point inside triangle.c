#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdlib.h>
float area(int x1, int y1, int x2, int y2, int x3, int y3)
{
   return abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
}


int main()
{   int x,y,x1,x2,x3,y1,y2,y3,T;
    scanf("%d",&T);
    do{
        scanf("%d %d %d %d %d %d %d %d",&x1,&y1,&x2,&y2,&x3,&y3,&x,&y);
   float A = area (x1, y1, x2, y2, x3, y3);
   float A1 = area (x, y, x2, y2, x3, y3);
   float A2 = area (x1, y1, x, y, x3, y3);
   float A3 = area (x1, y1, x2, y2, x, y);
   printf("%f  %f  %f  %f ",A,A1,A2,A3);
   if((A == A1 + A2 + A3)|| A==0)
     printf ("INSIDE\n");
   else
     printf ("OUTSIDE\n");
    T--;
}while(T>0);
   return 0;
}
