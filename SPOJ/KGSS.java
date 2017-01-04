package spoj;

/**
 * Created by sumit.jha on 11/17/16.
 */


//Make segment tree and store index as well along with the data. find max in range then query for second max in left and right of it.

public class KGSS {

    static int[] arr = new int[100001];
    static Node[] tree = new Node[400001];

    public static void build(int node,int start, int end){
        if(start == end){
            tree[node] = new Node(arr[start], start);

        } else {
            int mid = (start + end)/2;
            build(2*node, start,mid);
            build(2*node+1, mid+1, end);

            tree[node] = tree[2*node].value >  tree[2*node+1].value ?tree[2*node] : tree[2*node+1] ;
        }
    }

    public static void update(int node, int start, int end, int idx, int val){
        if(start == end){
            tree[node] = new Node(val,idx);
            arr[idx] = val;
        } else {
            int mid = (start + end)/2;


            if(start <= idx && idx <=mid){
                update(2*node, start,mid,idx,val);

            } else {
                update(2*node+1, mid+1, end,idx,val );
            }

            tree[node] = tree[2*node].value >  tree[2*node+1].value ?tree[2*node] : tree[2*node+1] ;
        }


    }

    public static Node query(int node, int start, int end, int l, int r){
        if(r < start || end < l){
            return new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        if(l<=start &  end <= r){
            return tree[node];
        }

        int mid = (start + end )/2;

        Node n1 =  query(2*node, start,mid,l,r);
        Node n2 =  query(2*node+1, mid+1, end,l,r);

         return (n1.value > n2.value ? n1: n2);


    }


    public static void main(String[] args) throws Exception{
        Reader in = new Reader();
        int n = in.nextInt();
        for(int i=0; i<n; i++ ){
            arr[i] = in.nextInt();
        }


        build(1, 0, n-1);
        int  t = in.nextInt();

        while (t--!=0){

            String ip[] = in.readLine().split(" ");
            String c = ip[0];
            int x =  Integer.parseInt(ip[1]);
            int y =  Integer.parseInt(ip[2]);

            if(c.equals("Q")){

                Node node = query(1, 0, n-1, x-1,y-1);
                int max1 = node.value;
                int max2;
               Node n1 = query(1, 0,n-1, x-1, node.idx-1);
               Node n2 = query(1, 0,n-1,  node.idx+1, y-1);

               if(n1.value==Integer.MIN_VALUE && n2.value==Integer.MIN_VALUE){
                  max2 = 0;
               } else {

                   max2 = Math.max(n1.value , n2.value);
               }



                System.out.println(max1+max2);


            } else {
                update(1,0,n-1,x-1,y);
            }
        }
    }




}


class Node {

    int value;
    int idx; //return idx of this val in segment tree

    public Node(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}