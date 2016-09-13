package spoj;

import java.io.PrintWriter;
import java.util.BitSet;

/**
 * Created by sumit.jha on 9/9/16.
 */
public class DANGER {

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        String s = in.readLine();
        while (!s.equals("00e0")) {

            out.println(solve(s));
            s = in.readLine();
        }
    }

    static long solve(String s) {

        int zeros = s.charAt(3) - '0';
        char x = s.charAt(0);
        char y = s.charAt(1);

        String str = Character.toString(x) + Character.toString(y);
        while(zeros--!=0){
            str+= "0";

        }

        long num = Long.valueOf(str);

        int pow =0;
        int i=1;
        while(i*2 <= num){
            pow++;
            i=i*2;
        }

        long k = num -  Double.valueOf(Math.pow(2, pow)).longValue();

        return 2*k + 1;




    }
}
