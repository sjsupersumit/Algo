package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by sumit.jha on 8/20/16.
 */
public class SBANK {

  public static void main(String args[]) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t--!=0){
      int n =Integer.parseInt(br.readLine());
      Map<String,Integer> bankAccounts = new HashMap<String,Integer>();
      while(n--!=0){

        String acc = br.readLine().trim();
        if(bankAccounts.containsKey(acc)){
          int val = bankAccounts.get(acc) + 1;
          bankAccounts.put(acc,val);
        } else {
          bankAccounts.put(acc,1);
        }

      }

      //print op
      SortedSet<String> keys = new TreeSet<String>(bankAccounts.keySet());
      for(String key: keys){
        System.out.print(key + " ");
        System.out.println(bankAccounts.get(key));
      }


      if(t!=0){
        br.readLine();
        System.out.println();
      }
    }
  }
}
