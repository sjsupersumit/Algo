package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/9/16.
 */
public class SILVER {

    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int n = in.nextInt();

        while (n != 0) {
            out.println(solve(n));
            n = in.nextInt();
        }
    }

    static int solve(int n) {

        int pieces = 0;

        while (n != 0) {
            n = n >> 1;
            pieces++;

        }
        return pieces-1;
    }
}
