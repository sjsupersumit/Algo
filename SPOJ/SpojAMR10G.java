import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by sumit.jha on 6/20/16.
 */


public class SpojAMR10G {

  static int[] arr = new int[20001];
  public static void main(String[] args) throws IOException{
    int t,n,k,i,j;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = parseInt(br.readLine());

    while(t--!=0){
      String[] temp = br.readLine().split(" ");
      n = parseInt(temp[0]);
      k = parseInt(temp[1]);

      temp = br.readLine().split(" ");
      for(i=0;i<n;i++){
        arr[i] = parseInt(temp[i]);
      }

      if(k==1){
        System.out.println("0");
      } else {

        Arrays.sort(arr, 0, n);
        int ans = Integer.MAX_VALUE;
        i = 0;
        while (i <= n - k ) {

          ans = (arr[i + k - 1] - arr[i]) < ans ? arr[i + k-1] - arr[i] : ans;
          i++;

        }

        System.out.println(ans);
      }

    }

  }
}
