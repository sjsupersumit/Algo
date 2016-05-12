#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int main(){

string s= "0123456789";
int i =1;
while(i++ < 1000000)
next_permutation(s.begin(),s.end());
cout<<s;
return 0;
}


