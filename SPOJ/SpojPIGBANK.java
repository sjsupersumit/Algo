import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;



/**
 * Created by sumit.jha on 6/20/16.
 */
public class SpojPIGBANK {


  static coin arr[] = new coin[501];
  static int weight,n;
static int[][] dp = new int[501][100001];

  public static void main(String args[]) throws IOException{

    String[] temp;
    int t,e,f,p,w,i;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = parseInt(br.readLine());
    while(t--!=0){

      temp = br.readLine().split(" ");
      e = parseInt(temp[0]);
      f = parseInt(temp[1]);
      n = parseInt(br.readLine());
      weight = f-e;

      for(i =0 ;i<n;i++){
        temp = br.readLine().split(" ");
        arr[i] = new coin(parseInt(temp[1]), parseInt(temp[0]));
      }


      Answer answer = new Answer();

//      solve(weight,0,answer);

      int ans = solvedp();
      if(ans == 999999){
        System.out.println("This is impossible.");
      } else {
        System.out.println("The minimum amount of money in the piggy-bank is " + ans + ".");
      }
    }

  }


 static int solve(int wt,int ans, Answer answer){


   if(wt < 0){
     return -1;
   }

   if(wt == 0){
     answer.bestAns = answer.bestAns < ans ? answer.bestAns:ans;
     return answer.bestAns;
   }


   for(int i=0;i<n;i++){

     solve(wt - arr[i].weight,ans+arr[i].value, answer);
   }

   return ans;
  }

  static int solvedp(){

    Arrays.sort(arr,0,n-1, new Comparator<coin>() {
      @Override
      public int compare(coin o1, coin o2) {
        return o1.weight - o2.weight ;
      }
    });
    int dp[] = new int[weight+1];
    Arrays.fill(dp,999999);

    dp[0] = 0;

    for(int i=0; i<n;i++){
      for(int j = arr[i].weight; j<=weight; j++) {
        if (dp[j] > dp[j - arr[i].weight] + arr[i].value) {
          dp[j] = dp[j - arr[i].weight] + arr[i].value;
    }
  }
 }


  return dp[weight];

  }






  static class Answer{
    int bestAns;

    public Answer() {
      bestAns = Integer.MAX_VALUE;
    }
  }





  static class coin{
    public int weight;
    public int value;

    public coin(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }
  }
}
