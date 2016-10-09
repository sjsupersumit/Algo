package spoj;

import java.io.PrintWriter;
import java.util.Arrays;


/**
 * Created by sumit.jha on 10/9/16.
 */



/* Java gives TLE same code in C++ is AC    */
public class DQUERY {

    public static int[] count = new int[1000001];
    public static int[] ans;
    public static int block ;
    static int[] arr;
    static int currUnique = 0;


    public static void main(String[] args) throws Exception{
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
     arr = new int[n];
        block =  (int)Math.sqrt(n);


        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int q = in.nextInt();
        Query[] queryArr = new Query[q];
        ans = new int[q];

        for(int i = 0; i<q;i++){
            int l = in.nextInt()-1;
            int r = in.nextInt()-1;

            Query query = new Query(l,r,i);
            queryArr[i] = query;
        }

        Arrays.sort(queryArr);

        int currL =0, currR=0;

        for(int i=0; i<q;i++){
             int L = queryArr[i].l;
             int R = queryArr[i].r;

            while(currL < L) {
                remove(currL);
                currL++;
            }
            while(currL > L) {
                add(currL-1);
                currL--;
            }
            while(currR <= R) {
                add(currR);
                currR++;
            }
            while(currR > R+1) {
                remove(currR-1);
                currR--;
            }

            ans[queryArr[i].i]  =currUnique;
        }


        //print the queryAns
        for(int i=0;i<q;i++){
            out.println(ans[i]);
        }




    }

    static void add(int position) {
        count[arr[position]]++;
        if(count[arr[position]] == 1) {
            currUnique++;
        }
    }

   static void remove(int position) {
        count[arr[position]]--;
        if(count[arr[position]] == 0) {
            currUnique--;
        }
    }





    static class Query implements Comparable<Query>{
        int l;
        int r;
        int i;

        public Query(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;

        }

        @Override
        public int compareTo(Query o) {
            if(this.l/block != o.l/block)
                return this.l/block - o.l/block;

            return this.r - o.r;


        }

    }
}
