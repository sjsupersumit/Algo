package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/14/16.
 */
public class MCOINS {

    static int MAX = 1000009;
    static int arr[] = new int[MAX];   //1 if player A wins, 0 uninitialized and 2 for B
    static int k, l;


    public static void main(String args[]) throws Exception {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        arr[0] = 2;
        arr[1] = 1;

        k = in.nextInt();
        l = in.nextInt();
        int t = in.nextInt();

        solve();

        while (t-- != 0) {

            int coins = in.nextInt();
            if (arr[coins] == 1)
                System.out.print("A");
            else
                System.out.print("B");


        }
    }


    static void solve() {

        for (int i = 2; i < MAX; i++) {

            int choice1 = i - 1 - 1;
            int choice2 = i - 1 - l;
            int choice3 = i - 1 - k;
            int choice4 = i - k - 1;
            int choice5 = i - k - l;
            int choice6 = i - k - k;
            int choice7 = i - l - 1;
            int choice8 = i - l - l;
            int choice9 = i - l - k;
            arr[i] = 2;

            if (whoWon(i,1,1) == 1 && whoWon(i,1,l) == 1 && whoWon(i,1,k) == 1) {
                arr[i] = 1;
            }
            if (whoWon(i,k,1) == 1 && whoWon(i,k,l) == 1 && whoWon(i,k,k) == 1) {
                arr[i] = 1;
            }
            if (whoWon(i,l,1) == 1 && whoWon(i,l,l) == 1 && whoWon(i,l,k) == 1) {
                arr[i] = 1;
            }

        }
    }

    static int whoWon(int idx, int first, int sec) {


        if (idx == 0) return 2;

        if(idx - first == 0)  return 1;

        if(idx - first < 0) return 2;

        if(idx -first-sec == 0) return 2;

        if(idx -first-sec < 0) return 1;

        return arr[idx-first-sec];
    }
}
