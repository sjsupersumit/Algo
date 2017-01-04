package RandomAlgo;

import spoj.Reader;

import java.io.IOException;


/**
 * Created by sumit.jha on 12/12/16.
 */


/*
* The infamous Range Minimum Query (RMQ)
* */
public class SegmentTree {

    static int arr[] = new int[1000001];
    static int tree[] = new int[2000001];



    public static void build(int node, int start, int end){

        if(start == end ){
            tree[node] = arr[start];
        } else {

            int mid = (start + end )/2;

            build(2*node, start, mid);
            build(2*node+1, mid+1, end);

            tree[node] = Math.min(tree[2*node], tree[2*node+1]);
        }

    }

    public static void update(int node, int start, int end, int idx, int val){
        if(start == end){
            tree[node] = val;

        } else {

            int mid = (start + end)/2;

            if(start <= idx && idx <= mid){

                update(2*node, start, mid, idx,val);
            } else {

                update(2*node+1, mid+1, end,idx, val);
            }


            tree[node] = Math.min(tree[2*node], tree[2*node +1]);
        }
    }


    public static int query(int node, int start, int end ,int l, int r){


        //query compltely outside range, return max as we tracking min
        if(r < start || end  < l){
            return Integer.MAX_VALUE;
        }
        //if query is perfectly in range
        if(l<=start && end<=r ){
            return tree[node];
        }

        //partiallialy in range

        int mid = (start + end )/2;

        int val1 = query(2*node, start, mid, l,r);
        int val2 =query(2*node+1, mid+1, end,l,r);

        return Math.min(val1, val2);



    }


    public static void main(String args[]) throws IOException{

        Reader in = new Reader();
        int n = in.nextInt();
        int t = in.nextInt();

        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        build(1,0,n-1);

        while (t--!=0){
            String line[]  = in.readLine().split(" ");
            if(line[0].equals("q")){
              int ans =  query(1,0, n-1, Integer.parseInt(line[1])-1, Integer.parseInt(line[2])-1);
              System.out.println(ans);
            } else {

                update(1,0,n-1,Integer.parseInt(line[1])-1, Integer.parseInt(line[2])-1);

            }

        }


    }
}
