package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/21/16.
 */
public class FAVDICE {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int t = in.nextInt();

        while (t--!=0){
            int n = in.nextInt();
            int i=1;
            double ans=0.0d;

            while (i <=n)  {
                 ans+= (1.0/i);
                i++;
             }

            ans=ans*n;
            out.printf("%.2f\n",ans);

        }
    }
}
