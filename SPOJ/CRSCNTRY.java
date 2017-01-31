package spoj;

import java.io.IOException;

/**
 * Created by sumit.jha on 1/31/17.
 */
public class CRSCNTRY {

   private static final int MAX_LEN = 2001;
   private static int[] arr1 = new int[MAX_LEN] ;
   private static int[] arr2 = new int[MAX_LEN];
   private static int dp[][] = new int[MAX_LEN][MAX_LEN];

    public static void main(String args[]) throws IOException {
        Reader in = new Reader();
        int t = in.nextInt();

        while (t--!=0) {

            int val = in.nextInt();
            int max= 0;
            int i = 0;
            while (val != 0) {
                arr1[i++] = val;
                val = in.nextInt();
            }
            int len1 = i;

            while (true) {

                int val2 = in.nextInt();
                if(val2 == 0){
                    break;
                }
                i = 0;
                while (val2 != 0) {
                    arr2[i++] = val2;
                    val2 = in.nextInt();
                }

                int len2= i ;
                int lcs = getLcs(len1,len2);
                if(lcs > max) max = lcs;

            }

            System.out.println(max);
        }
    }


   private static int getLcs(int len1, int len2){
        for(int i=0; i<=len1; i++){
            for(int j=0; j<=len2; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
