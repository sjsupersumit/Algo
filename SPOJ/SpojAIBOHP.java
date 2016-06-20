import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.reverse;

/**
 * Created by sumit.jha on 6/20/16.
 */
public class SpojAIBOHP {

  static int dp[][] = new int[ 6100+1][6100+1];

  public static void main(String args[]) throws IOException{
    int i,j,t,ans;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = parseInt(br.readLine());
    while(t--!=0){

      String str = br.readLine();
      String rev = new StringBuffer(str).reverse().toString();
      int len = str.length();

      for(i=0;i<=len;i++){
        for(j=0; j<=len ; j++){

          if(i==0 || j== 0){
            dp[i][j] = 0;
          }else if(str.charAt(i-1) == rev.charAt(j-1)){
            dp[i][j] = dp[i-1][j-1] + 1;

          } else {

            dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
          }


        }
      }

      System.out.println(len - dp[len][len]);
    }

  }
}
