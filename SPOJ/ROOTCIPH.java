package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 10/2/16.
 */
public class ROOTCIPH {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        while (t--!=0){
            Long a = in.nextLong();
            Long   b = in.nextLong();
            Long c = in.nextLong();

            long ans = ((a*a) - (2*b));
            out.println(ans);

        }
    }
}
