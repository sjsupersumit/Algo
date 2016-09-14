package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sumit.jha on 9/13/16.
 */
public class CPRMT {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s1 = in.readLine();
        while (s1 != null && !s1.isEmpty()) {

            String s2 = in.readLine();
            int seen[] = new int[26];
            int sl = s1.length() < s2.length() ? s1.length() : s2.length();
            String op = "";
            for (int i = 0; i < s1.length(); i++) {
                int idx = s1.charAt(i) - 97;
                seen[idx] = seen[idx] + 1;
            }

            for (int i = 0; i < s2.length(); i++) {

                int idx = s2.charAt(i) - 97;
                if (seen[idx] != 0) {
                    op += s2.charAt(i);
                    seen[idx] = seen[idx] - 1;
                }
            }

            char[] ar = op.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
            System.out.println(sorted);


            s1 = in.readLine();
        }
    }
}
