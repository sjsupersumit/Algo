/*
 *THIS IS WRONG PROGRAM AS IT FINDS ALL PERMUTATION 
 *BUT Q35 SAYS CIRCULAR PRIME WHICH CAN BE FOUND ONLY BY ROTATION
 *
 *THI CODE IS FOR HISTORICAL PURPOSES, MEANT TO BE READ ONLY BY ITS AUTHOR, 
 *SUMIT JHA
 *NOT FOR OUTSIDE WORD
 */
#include <iostream>
#include <vector>
#include <algorithm>

#define limit 1000001
using namespace std;

int prime[limit];

void seive(){
  for(long i=0;i<limit;i++)
    prime[i]=1;

  prime[0]=prime[1]=0;

  for(long i=2;i<limit;i++){
    if(prime[i]){
      for(long j=i; j*i<limit;j++){
        prime[j*i]=0;
      } 
    }
  } 
}



void generateAllPermutation(vector<string> &allPerm, string s, int i, int n){

  if(i == n){
    allPerm.push_back(s);
  }
  else{
    for(int j=i;j<n;j++){
      swap(s[i], s[j]);
      generateAllPermutation(allPerm,s,i+1,n);
      swap(s[i], s[j]);
    }
  }
}


int main(){
  seive();
  string s;
  int cnt=0;

cout<<"prime chck\n";
cout<<"197-->"<<prime[197];
cout<<"971-->"<<prime[971];
cout<<"719-->"<<prime[719];



  for(long i=1;i<200;i++){
    if(prime[i]){
      cout<<"Checking For\t"<<i<<"\n";
      bool allPrime= true;
      s = to_string(i);
      vector<string> allPermutation ;
      generateAllPermutation(allPermutation, s,0,s.size());
      cout<<"\nAll Permutation"<<"\n";
      for(auto it= allPermutation.begin(); it!=allPermutation.end(); it++){
        long val = stoi(*it);
        cout<<val<<"--->"<<prime[val]<<"\n";
        if(!prime[val]){
        allPrime=false;
        break;
        } 
      }
      if(allPrime){
       cout<<"\nFOUND"<<i<<"\n";
        cnt++;

      }
    }
  }
    return 0;
  }
