package spoj;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sumit.jha on 1/24/17.
 */
public class CADYDIST {

    static final int MAX_LENGTH = 100001;
    static long[] nArr = new long[MAX_LENGTH];
    static long[] pArr = new long[MAX_LENGTH];


    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        int t = in.nextInt();

        while(t!=0){

            for(int i=0; i<t;i++){
                nArr[i] = in.nextLong();
            }

            for(int i=0; i<t;i++){
                pArr[i] = in.nextLong();
            }

            Arrays.sort(nArr,0,t);
            Arrays.sort(pArr,0,t);


            long ans = 0;

            for(int i=0; i< t;i++){
                ans+= pArr[i] * nArr[t-i-1];
            }

            System.out.println(ans);



            t = in.nextInt();
        }


    }
}
