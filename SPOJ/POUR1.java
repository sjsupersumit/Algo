package spoj;

/**
 * Created by sumit.jha on 1/30/17.
 */
public class POUR1 {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        int t = in.nextInt();
        while(t-- != 0){
            int a = in.nextInt() ;
            int b = in.nextInt() ;
            int c = in.nextInt() ;

            if(c ==a || c == b){
                System.out.println(1);
            } else if( (c>a && c>b) || c%gcd(a,b)!=0 ){

                System.out.println(-1);
            } else {


                int sol = getSolution(a, b, c);
                int sol1 = getSolution(b, a, c);

                System.out.println((int) Math.min(sol, sol1));

            }
        }
    }

    static int gcd(int a , int b){
        return (b!=0) ?  gcd(b,a%b) : a;
    }


    //god damn simulation
    static int getSolution(int a, int b , int c){

        int move=1;
        int currA=a, currB=0, rem;

        while (currA!=c && currB!=c ){
            rem = Math.min(currA, b-currB);
            currB+=rem;
            currA-=rem;
            move++;

            if(currA==c || currB==c)
                break;
            if(currA==0){
                currA = a;
                move++;
            }
            if(currB == b){
                currB =0 ;
                move++;
            }

        }

        return move;
    }
}
