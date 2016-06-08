#include <iostream>
#include <vector>
#include <cstdio>

using namespace std;

int main(){
  ios::sync_with_stdio(false);
  int t,a;
  cin >>t;
  t=t-1;
  cin>>a;
  int ans=a;
  while(t--){
  cin>>a;
   ans = ans^a;
  }
cout<<ans;

return 0;
}
