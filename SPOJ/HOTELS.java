package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sumit.jha on 8/21/16.
 */
public class HOTELS {

  public static void main(String args[]) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n,m;
    String[] temp = br.readLine().split(" ");
    n = Integer.parseInt(temp[0]);
    m = Integer.parseInt(temp[1]);
    int arr[]  = new int[n+1];
    temp = br.readLine().split(" ");
    for(int i=0;i<temp.length;i++){
      arr[i] = Integer.parseInt(temp[i]);
    }

    int max_here=arr[0], max_so_far = 0;
    int wl=0;
    int wr=1;

    if(max_here > max_so_far && max_here <= m){
      max_so_far = max_here;
    }



    while(max_so_far<m && wl<wr){

      if(max_here < m && wr<n){

        max_here += arr[wr];
        wr++;
      } else {
        max_here -= arr[wl];
        wl++;

      }

      if(max_here > max_so_far && max_here <= m){
        max_so_far = max_here;
      }

    }


    System.out.println(max_so_far);

  }
}
