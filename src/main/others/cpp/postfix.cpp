#include<iostream>
#include<string.h>
using namespace std;
char stac[400];
int top=-1;
class postfix
{ int pri;
public:
    int priority(char oper)
    {
        if (oper=='(')
                pri=1;
        if(oper=='+')
            pri=2;
            if(oper=='-')
            pri=3;
            if(oper=='*')
                pri=3;
            if(oper=='/')
                pri=4;
            if(oper=='^')
                pri=5;
            return pri;
    }
    void push(char store)
    {
        top=top+1;
        stac[top]=store;
    }
    void pop()
    {
        cout<<stac[top];
        top=top-1;
    }
}obj;
int main()
{   int inp,len,i;char exp[400],test[2],c;
    cout<<"enter the expression\n";
    cin>>exp;
    c=')';
    test[0]=c;
    test[1]='\0';
    strcat(exp,test);
    len=strlen(exp);
    cout<<len;
    for(i=0;i<len;i++)
    cout<<exp[i];
    obj.push('(');
    for(i=0;i<len;i++)
    {

        if(exp[i]=='('||exp[i]==')'||exp[i]=='+'||exp[i]=='-'||exp[i]=='*'||exp[i]=='/'||exp[i]=='^')
        {   if(exp[i]=='(')
            obj.push(exp[i]);
            if(exp[i]==')')
            {while(stac[top]!='(')
                   {
                obj.pop();
                   }
            }
            while((obj.priority(stac[top]))>=(obj.priority(exp[i])))
            obj.pop();
            obj.push(exp[i]);
        }
        else{
            cout<<exp[i];
        }
    }

}
