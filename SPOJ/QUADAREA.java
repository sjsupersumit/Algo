package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sumit.jha on 8/20/16.
 */
public class QUADAREA {
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t--!=0){
      String[] temp = br.readLine().split(" ");
      double a = Double.parseDouble(temp[0]);
      double b = Double.parseDouble(temp[1]);
      double c = Double.parseDouble(temp[2]);
      double d = Double.parseDouble(temp[3]);
//Brahmguptas formula
      double ans = Math.sqrt((-a+b+c+d)* (a-b+c+d) * (a+b-c+d) * (a+b+c-d)) /4;
      System.out.println(ans);


    }
  }
}
