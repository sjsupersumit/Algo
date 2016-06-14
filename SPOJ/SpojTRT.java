import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;



/**
 * Created by sumit.jha on 6/10/16.
 */
public class SpojTRT {
  static int dp[][] = new int[2002][2002];
  static int t;
  static int arr[] = new int[2002];

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int i,j,k;

    t= parseInt(br.readLine());



    for(i=0;i<t;i++){
      arr[i] = parseInt(br.readLine());
    }

    for(int[] row: dp ){
      Arrays.fill(row,-1);
    }
    //findBest(arr,0,t-1,1,0);
     System.out.print(findBest( 0, t-1));

  }

  static int findBest( int start, int end ){

    if(start > end){
      return 0;
    }

    if(dp[start][end] !=-1){

      return dp[start][end];

    }
    int age =  t - (end - start);


   int res =  Math.max(age * arr[start] + findBest(start+1,end),age * arr[end] + findBest(start,end-1));
    dp[start][end] = res;
    return res;
  }

}
