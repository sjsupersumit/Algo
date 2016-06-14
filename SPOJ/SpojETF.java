import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by sumit.jha on 6/9/16.
 */

/*
* Remember these Identities while calculating the toitent function
*
* if gcd(m,n) = 1, phi(mn) = phi(m) * phi(n)
  if p is prime, phi(p) = p - 1 (for p < 10^20)
  if n is even, phi(2n) = 2 phi(n)
*
* */

public class SpojETF {



//Same login in cpp is AC. but This sol gives TLE so use fast I/O

  static int calc(int n){
    int result = n;
    int i;
    for(i=2;i*i <= n;i++)
    {
      if (n % i == 0)
        result -= result / i;
      while (n % i == 0)
        n /= i;
    }
    if (n > 1)
      result -= result / n;
    return result;


  }


  public static void main(String args[]) throws IOException {

    //calulatePhiALL();
    int t, n;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = parseInt(br.readLine());

    while (t-- != 0) {
      n = parseInt(br.readLine());
      System.out.println(calc(n));
    }
  }
}
