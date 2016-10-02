package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/23/16.
 */
public class TRGRID {

    public static void main(String args[]) throws Exception{
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int t = in.nextInt();
        while(t--!=0){

            int n = in.nextInt();
            int m = in.nextInt();

            int max = Math.max(m,n);
            int layers = (int)(max/2.0);
            int totalTurns = layers*2;

            //R,D,L,U

            if(n <= m)
            {
                if(n%2==0)out.println("L");
                else if(n%2==1) out.println("R");
            }
            else if(n > m)
            {
                if(m%2==0)out.println("U\n");
                else if(m%2==1) out.println("D\n");
            }






        }
    }
}
