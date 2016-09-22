package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/18/16.
 */
public class AMR12D {

    public static void main(String[] args) throws Exception{


        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out,true);
        int t= in.nextInt();
        while(t--!=0){

            String s = in.readLine();
            if(s.equals(new StringBuilder(s).reverse().toString())){
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
}
