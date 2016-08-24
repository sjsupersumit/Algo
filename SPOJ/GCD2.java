package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sumit.jha on 8/21/16.
 */

//OOPS JAVA LANG IS NOT ALLOWED FOR THIS PROBLEM SUBMISSION(BUT IT WORKS),
// PERHAPS DUE TO BIGINT SUPPORT(BUT PYTHON IS ALLOWED). TIME TO SHOW SOME C++  SKILLS
public class GCD2 {


  static int gcd(int a, int b){

    if(b==0) return a;
    return gcd(b,a%b);

  }

  public static void main(String args[]) throws Exception{

    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t--!=0){

      String[] temp = br.readLine().split(" ");
      int a = Integer.parseInt(temp[0]);
      if(a==0){
        System.out.println(temp[1]);
      }
      int mod = findmod(temp[1],a);
      System.out.println(gcd(a,mod));
    }

  }

  static int findmod(String str, int a){
    int rem=0;
    for(int i=0; i<str.length();i++){

      int num = Integer.parseInt(String.valueOf(rem) + str.charAt(i));
      rem = num %a;

    }
    return rem;
  }

}
