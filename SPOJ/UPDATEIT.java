package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sumit.jha on 8/22/16.
 */

/*
*
* //Gives TLE on spoj. Use Cpp version for passing the judges
*
* */
public class UPDATEIT {

  static int arr[] = new int[10001];
  static int T[] = new int[10001];

  public static void main(String args[]) throws Exception {
    int t;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    while (t-- != 0) {

      int n, u, q, l, r, val;
      String[] temp = br.readLine().split(" ");
      n = Integer.parseInt(temp[0]);
      u = Integer.parseInt(temp[1]);
      Arrays.fill(arr, 0);
      Arrays.fill(T, 0);

      while (u-- != 0) {
        temp = br.readLine().split(" ");
        l = Integer.parseInt(temp[0]);
        r = Integer.parseInt(temp[1]);
        val = Integer.parseInt(temp[2]);

        update(l, r, val);
      }
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt += T[i];
        arr[i] = cnt;
      }

      int qn = Integer.parseInt(br.readLine());
      while (qn-- != 0) {
        q = Integer.parseInt(br.readLine());
        System.out.println(get(q));
      }

    }
  }


  static void update(int l, int r, int val) {

    T[l] += val;
    T[r + 1] -= val;
  }


  static int get(int q) {
    return arr[q];
  }

}
