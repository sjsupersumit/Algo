package spoj;

import java.util.Arrays;

/**
 * Created by sumit.jha on 1/6/17.
 */
public class AMR11E {

    private static int ans[] = new int[1001];
    private static boolean prime[] = new boolean[100001];


    static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i < Math.sqrt(100001); i++) {
            if (prime[i]) {
                for (int j = i * i; j < 100001; j += i) {
                    prime[j] = false;
                }
            }
        }
    }


    static void generateNotSphenicNumbers() {  // these are not sphenic numbers. :(:(

        sieve();
        int idx = 1;


        for (int i = 4; i <= 10001; i++) {
            int flag = 0;
            if(idx  > 1000) {
                break;
            }

            for (int j = 2; j <= i / 2; j++) {
                if (prime[j]) {


                    if (i % j == 0)
                        flag++;

                    if (flag >= 3) {
                        ans[idx++] = i;
                        break;
                    }

                }
            }
        }


    }


    public static void main(String args[]) throws Exception {
        Reader in = new Reader();
        int t = in.nextInt();
        generateNotSphenicNumbers();
        while (t-- != 0) {

            int idx = in.nextInt();
            System.out.println(ans[idx]);

        }

    }
}
