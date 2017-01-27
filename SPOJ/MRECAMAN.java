package spoj;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sumit.jha on 1/24/17.
 */
public class MRECAMAN {

    static final int MAX_LENGTH = 500001;
    static long[] dp = new long[MAX_LENGTH];
    static Set<Long> hset = new HashSet<>(MAX_LENGTH);


    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        int k = in.nextInt();
        getNumber(MAX_LENGTH-1);
        while(k != -1){
            System.out.println(dp[k]);
            k = in.nextInt();
        }


    }

    public static void getNumber(int k){

       for(int i=1;i<=k;i++){
           long val = dp[i-1];

           if(val -i > 0 && !hset.contains(val-i)) {
               dp[i] = val - i;
           } else  {
               dp[i] = val + i;

           }
           hset.add(dp[i]);
       }
    }

}
