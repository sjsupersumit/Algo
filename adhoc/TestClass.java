
/*
* Test input
*
* 23
4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21
9 2

ans =  5


o/p find common meeting cell which is nearest to both a and b, above given val is graph
*
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class TestClass {
 static long[] arr = new long[1000001];
  public static void main(String args[] ) throws Exception {


    long j,k,n,val,cnt=0,a,b;
    int key,i;

    Scanner in = new Scanner(System.in);
    n  = in.nextInt();

    for(i=0;i<n;i++){
      j = in.nextInt();
      arr[i] = j;
    }
    a = in.nextInt();
    b= in.nextInt();

    cnt = 1;
    Map<Long, Long> aPath = new HashMap<>();
    Map<Long, Long> bPath = new HashMap<>();

     key = (int)a;

    while(arr[key]!=-1 && aPath.get(arr[key]) == null){
      aPath.put(arr[key], cnt);
      cnt+=1;
      key = (int)arr[key];
    }

    key = (int)b;
    cnt=1;
    while(arr[key]!=-1 && bPath.get(arr[key])==null){
      bPath.put(arr[key],cnt);
      cnt+=1;
      key = (int)arr[key];

    }

    long ans = -1;
    long minDis = 9999999;


    for(Long l : aPath.keySet()){
      cnt = 0;
      Long bval = bPath.get(l);
      if(bval!=null){

        cnt = bval + aPath.get(l);

        if(cnt < minDis){
          minDis = cnt;
          ans = l;
        }
      }

    }

    System.out.print(ans);

  }
}
