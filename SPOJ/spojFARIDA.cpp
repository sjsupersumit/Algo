#include <iostream>
#include <vector>
#include <cstdio>
#include <algorithm>
using namespace std;

int main(){
int n,t,i,j;

cin>>t;
for(i=1;i<=t;i++){

 long long int inclusive=0,exclusive=0;
  cin>>n;
cin >> inclusive;

for(int j=1;j<n;j++){

 long long int curr,temp;
cin >> curr;
temp = max(inclusive,exclusive);
inclusive = exclusive+ curr;
exclusive = temp;






}
cout<<"Case "<<i<<": "<<max(inclusive,exclusive)<<"\n";
}





return 0;
}
