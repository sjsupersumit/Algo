#include <iostream>
#include <vector>
#include <cstdio>

using namespace std;

int divisors(int n){
  if(n==1) return 1;
  int count=2, i=2;

  while(i*i < n){
    if(n%i == 0)
      count+=2;
    i+=1;
  }
  if(i*i == n){
    count+=1;
  }

  return count;
}


int gcd1(int a, int b){
  if(b==0) return a;
  if(a==0) return b;
  return gcd1(b,a%b);
}


int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t,x,y,gcd;

  cin>>t;
  while(t--){
    cin >>x>>y;
    int gcd = gcd1(x,y);
    if(gcd == 1){
      cout<<"1\n";
    }
    else{
      int cnt = divisors(gcd);
      cout<<cnt<<"\n";


    }




  }
  return 0;
}


