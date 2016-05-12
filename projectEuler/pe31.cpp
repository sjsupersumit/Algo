#include <iostream>

using namespace std;

int cnt(int *money, int n, int sum, int curr_index){

  if(sum == 0){
    return 1;
  }

  if( sum < 0) return 0;

  if(curr_index > n-1)
    return 0;

  return cnt(money,n,sum-money[curr_index],curr_index) + cnt(money, n, sum, curr_index+1);






}


int main(){

  int money[8] = {1,2,5,10,20,50,100,200};
  int n = sizeof(money)/sizeof(int);
  int sum = 200;
  cout<<cnt(money,n,sum,0 );

  return 0;
}





