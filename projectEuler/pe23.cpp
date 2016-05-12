#include <iostream>
#include <math.h>
using namespace std;


int MAX_LIMIT = 28123;
bool ab_num[28124] = {false};
bool is_abundant_sum(int);

int main(){
  
  int i,j,k,l; // AS 16 is 1st number which could be written as their sums
  long long sum = 0;

  for(i=12; i <= MAX_LIMIT;i++){
    int s_f =1;
    for(int d = 2; d <= (i/2); d++){
      if(i%d == 0) s_f+= d;
    }

    //cout<<"\n s_f for "<<i<<" is "<<s_f;
    if(s_f > i)
      ab_num[i] = true;
  }


  for(i=1; i<= MAX_LIMIT; i++){
    if(!is_abundant_sum(i)){
      sum+= i;
    }
  }
  cout<<sum;
  return 0;
}


bool is_abundant_sum(int i){

  bool res = false;
  //12 is first abundant number
  for(int k = 12; (k <<1) <= i ; k++){

    if( ab_num[k] && ab_num[i-k]){
      res = true;
     break; 
     
      //cout<<"\n"<<i<< " Can be Written as "<<k<<" "<< i-k ;
    }
  }

  return res;
}

