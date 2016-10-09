package spoj;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by sumit.jha on 10/2/16.
 */

//TLE on spoj but same solution in c++ is AC

public class SUMFOUR {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int n = in.nextInt();
        int len = 4*n;
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        int d[] = new int[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            c[i] = in.nextInt();
            d[i] = in.nextInt();



        }
        int idx=0;
        long[] first = new long[n*n];
        long[] second = new long[n*n];

        for(int i=0; i<n;i++)
            for(int j=0;j<n;j++){

                first[idx] = a[i] + b[j];
                second[idx] = c[i] + d[j];
                idx++;

            }

        long ans = 0;

        Arrays.sort(second);
        Arrays.sort(first);

        int i=0,j=idx-1;
        int freq1=1,freq2=1;

        while(i<idx && j>=0)
        {
             long sum=first[i]+ second[j];
            while(i+1<idx && first[i]==first[i+1]) {freq1++;i++;}

            while(j-1>=0 && second[j]==second[j-1]){ freq2++ ; j-- ;}

            if(sum==0){
                ans+=freq1*freq2;
                i++;
                j--;
                freq1=1;
                freq2=1;
            }
            else if(sum>0){
            j--;  freq2=1;}
        else{ i++; freq1=1;}
        }





        out.println(ans);





    }
}
