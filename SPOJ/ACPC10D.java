package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/19/16.
 */


//Modifying miser Man to code quality is pretty bad
public class ACPC10D {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int cnt = 0;
        while (true) {
            cnt++;
            int n = in.nextInt();
            int m = 3;

            if (n == 0) break;

            long[][] mat = new long[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {

                    mat[i][j] = in.nextInt();
                    if (i == 0 && j == 0)
                        mat[i][j] = Long.MAX_VALUE / 2;

                    if (!(i == 0 && j == 1)) {
                        long min = Long.MAX_VALUE / 2;
                        long top = (i == 0) ? min : mat[i - 1][j];
                        long left = (j == 0) ? min : mat[i][j - 1];
                        long topleft = (i == 0 || j == 0) ? min : mat[i - 1][j - 1];
                        long topright = (i == 0 || j == 2) ? min : mat[i - 1][j + 1];

                        mat[i][j] += Math.min(Math.min(top, left), Math.min(topleft, topright));
                    }
                }
            }
            out.println(cnt + ". " + mat[n - 1][1]);
        }
        System.exit(0);
    }


    private static boolean checkBound(int x, int y, int r, int c) {

        if (x < 0 || y < 0)
            return false;

        if (x >= r || y >= c)
            return false;

        return true;
    }
}
