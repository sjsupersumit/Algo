package spoj;

/**
 * Created by sumit.jha on 1/9/17.
 */
public class BRCKTS {

    public static char[] str;
    static Node[] tree = new Node[1200001];

    public static void build(int node, int start, int end){

        if(start  == end){

            tree[node] =  str[start] == '(' ? new Node(1,0): new Node(0,1);

        } else {

            int mid = (start + end )/2;
            build(2*node, start, mid);
            build(2*node+1, mid+1, end);


            int leftUOpened = tree[2*node].uOpened;
            int rightUClosed = tree[2*node + 1].uClosed;
            int newMatches = Math.min(leftUOpened, rightUClosed);

            if(tree[node] ==null) {
                tree[node] = new Node(tree[2*node].uOpened + tree[2*node + 1].uOpened - newMatches, tree[2*node].uClosed + tree[2*node + 1].uClosed - newMatches);
            } else {
                tree[node].uOpened = tree[2*node].uOpened + tree[2*node + 1].uOpened - newMatches;
                tree[node].uClosed = tree[2*node].uClosed + tree[2*node + 1].uClosed - newMatches;
            }
        }
    }


    public static void update(int node, int start, int end, int idx){

        if(start == end){

            if(str[idx] == '('){
                tree[node].uOpened = 0;
                tree[node].uClosed = 1;
            } else {
                tree[node].uOpened = 1;
                tree[node].uClosed = 0;
            }

            str[idx] =  str[idx] == '(' ? ')' : '(' ;

        } else {

            int mid = (start + end )/2;

            if(start <= idx && idx <= mid ){
                update(2*node, start, mid,idx);
            } else {
                update(2*node+1, mid+1, end, idx);
            }


            int leftUOpened = tree[2*node].uOpened;
            int rightUClosed = tree[2*node + 1].uClosed;
            int newMatches = Math.min(leftUOpened, rightUClosed);


            tree[node].uOpened = tree[2*node].uOpened + tree[2*node + 1].uOpened - newMatches;
            tree[node].uClosed = tree[2*node].uClosed + tree[2*node + 1].uClosed - newMatches;


        }


    }


    public static boolean query(){

        return (tree[1].uOpened == 0) && (tree[1].uClosed == 0);


    }



    //checks if string is balanced or not
    public static boolean isBalanced(StringBuilder sb){

        if(sb == null || sb.length() == 0) return true;

        if( ((sb.length() & 1) == 1)) return false; //odd length string cant be balanced

        int count = 0;

        for(int i=0; i< sb.length() ; i++){


            char c = sb.charAt(i);

            if(c == '(') {
                count++;
            } else  {
                count--;
            }

            if(count  < 0){
                return false;
            }
        }



        return (count == 0);
    }





   static class Node{

       int uOpened;
       int uClosed;

       public Node(int uOpened, int uClosed) {
           this.uOpened = uOpened;
           this.uClosed = uClosed;
       }
   }

    public static void main(String args[]) throws Exception {

        Reader in = new Reader();

        int t = 10;
        while (t--!=0){

            int n = in.nextInt();
            String line = in.readLine();
            str = line.toCharArray();
            int T = in.nextInt();


            build(1, 0, n-1);
            System.out.printf("Test %d:\n" ,  10-t);

            while (T--!=0){

                int idx = in.nextInt();

                if(idx == 0){

                   System.out.println( query() ? "YES": "NO");

                } else {

                    update(1,0,n-1,idx-1);


                }

            }
        }


    }
}
