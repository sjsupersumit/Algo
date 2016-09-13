package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/13/16.
 */
public class GLJIVE {

    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int count = 10;
        int sum = 0;
        int prev = 0;
        while (count-- != 0) {

            int num = in.nextInt();
            prev = sum;
            sum += num;
            if (sum >= 100)
                break;
        }

        int prevabs = Math.abs(100 - prev);
        int sumabs = Math.abs(sum - 100);
        int res;

        if (prevabs == sumabs) {
            res = sum;
        } else {

            res = prevabs < sumabs ? prev : sum;
        }

        out.println(res);
    }

}
