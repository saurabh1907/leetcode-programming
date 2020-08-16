#include<stdio.h>
#include<conio.h>
#include<string.h>
int ninputs;
int next1(int);
int next2(char);
void define_DFA();
void stringvalidation();
int trans[20][20];
char c[20],string[20];
int nstates,nfinals,n;
int final[20],state[20],final_state=0;
int present_state,initial_state,next_state;
int main()
{
    int choice;
    define_DFA();
    do{
             stringvalidation();
             printf("Continue(1/2)?");
             scanf("%d",&choice);
    }while(choice==1);
}
void define_DFA()
{
    int i,j;
    printf("number of inputs:");
    scanf("%d",&ninputs);
    printf("\n enter input symbols \t");
    for(i=0; i<ninputs; i++)
    {
      printf("\n\n %d input\t", i+1);
      printf("%c",c[i]=getch());
    }
    printf("\n\n number of states in DFA\t:");
    scanf("%d",&nstates);
    for(i=0;i<nstates;i++)
    {
       printf("\n\n state %d:q",i+1);
       scanf("%d",&state[i]);
    }
    printf("\n\n initial_state  : q");
    scanf("%d",&initial_state);
    printf("number of final states:");
    scanf("%d",&nfinals);
    for(i=0;i<nfinals;i++)
    {
       printf("\n\nFinal state %d : q",i+1);
       scanf("%d",&final[i]);
    }
    printf("\n\n  transition rule is (present state, input symbol ) = next state\n");
    for(i=0; i<nstates; i++)
     {
              for(j=0; j<ninputs; j++)
              {
                       printf("\n(q%d , %c ) = q",i,c[j]);
                       scanf("%d",&trans[i][j]);
              }
     }
}
void stringvalidation()
{
   int i=0,j,states,inputs;
   char *str;
   present_state=initial_state;
   printf("\n\nEnter Input String.. ");
   fflush(stdin);
   gets(string);
   str=string;
   while(*str!='\0')
   {
     states=next1(present_state);
     inputs=next2(*str);
     next_state=trans[states][inputs];
     present_state=next_state;
     for(j=0 ;j<nfinals ;j++)
      {
       if(final[j] == present_state)
         final_state=1;
       else
         final_state=0;
      }
     str++;
    }
   if(final_state==1)
      printf("\n string accepted");
   else
     printf("string rejected");
  getch();
}
int next1(int d)
{
     int i;
    for(i=0;i<nstates;i++)
    {
      if(d==state[i])
                     return i;
    }
    return -1;
}
int next2(char b)
{
    int j;
    for(j=0;j<ninputs;j++)
    {
      if(b==c[j])
       return j;
    }
    return -1;
 }
