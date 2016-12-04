package spoj;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by sumit.jha on 10/13/16.
 */
public class PERMUT1 {

   static int dp[][] = new int[101][101];

    public static void main(String[] args) throws Exception{
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int t = in.nextInt();

        while (t--!=0){

            int n = in.nextInt();
            int k = in.nextInt();

            for(int i=0;i<101;i++){
                Arrays.fill(dp[i],-1);
            }

            int ans = solve(n,k);
            out.println(ans);

        }

    }


    static int solve(int n, int k){

            if(dp[n][k]!=-1) return dp[n][k];

        if(k==0) return (dp[n][k] = 1);

        if (n == 0)
            return (dp[n][k] = 0);

        int j = 0, val = 0;
        for (j = 0; j < n && k-j >= 0; j++)
            val += solve(n-1, k-j);
        return dp[n][k] = val;


    }
}
