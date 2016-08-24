#include<stdio.h>
int main()
{
 int t;
 scanf("%d",&t);
 while(t--)
 {
  int N,U;
  scanf("%d%d",&N,&U);
  int arr[N],T[N+1],val,low,high,i,count=0;
  for(i=0;i<=N;i++)
   T[i]=0;
  for(i=0;i<U;i++)
  {
   scanf("%d%d%d",&low,&high,&val);
   T[low]+=val;
   T[high+1]-=val;
  }
  for(i=0;i<N;i++)
  {
   count+=T[i];
   arr[i]=count;
  }
  int q,query;
  scanf("%d",&q);
  for(i=0;i<q;i++)
  {
   scanf("%d",&query);
   printf("%d\n",arr[query]);
  }
 }
 return 0;
}