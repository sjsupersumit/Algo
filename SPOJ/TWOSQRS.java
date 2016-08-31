package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sumit.jha on 8/26/16.
 */


//fermat theorem on squares z = x^2 + y^2 only if z %4==1 for odd primes z
public class TWOSQRS {

  public static void main(String args[]) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t--!=0){
      Long num = Long.parseLong(br.readLine());
        Double d=   (Math.sqrt(num));
        long i = d.longValue();
        long j=0;

        while (i>0){

          if(j*j > num){
            System.out.println("No");
            break;
          }

          else if (i*i + j*j == num){
            System.out.println("Yes");
            break;
          }
          else if(i*i + j*j < num){
            j++;
          } else{
            i--;
          }



        }




      }
    }


  }


