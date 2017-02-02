package spoj;

import java.util.Arrays;

/**
 * Created by sumit.jha on 2/2/17.
 */
public class BYTESE2 {

    private static final int MAX_LIMT = 101;
    private static int[] arrival = new int[MAX_LIMT];
    private static int[] departure = new int[MAX_LIMT];

    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        int t = in.nextInt();
        while (t-- != 0) {

            int n = in.nextInt();
            int max = 0;

            for (int i = 0; i < n; i++) {
                arrival[i] = in.nextInt();
                departure[i] = in.nextInt();

            }

            Arrays.sort(arrival, 0,n);
            Arrays.sort(departure, 0,n);

            int count = 0;
            for(int i = 0,j=0; i<n&&j<n;){

                if(arrival[i]  <  departure[j]){
                    count++;
                    i++;
                } else if (arrival[i] > departure[j]){
                    count--;
                    j++;
                }


                if (count > max)
                {
                    max =count;
                }
            }

            System.out.println(max);
        }
    }
}
