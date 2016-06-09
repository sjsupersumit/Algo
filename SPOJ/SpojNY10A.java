import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Created by sumit.jha on 6/8/16.
 */
public class SpojNY10A {


  public enum states {TTT, TTH, THT, THH, HTT, HTH, HHT,HHH}


  public static void main(String args[]) throws IOException{


    int i,j,k,t,n;
    Map<states, Integer> stateCount = new HashMap<states, Integer>();
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    t = parseInt(br.readLine());
    while(t--!=0){

      int count[] = new int[8];
      n = parseInt(br.readLine());
      String str = br.readLine();
      for(i=0;i<str.length() -2;i++){

        String temp = str.substring(i,i+3);
        states currState = states.valueOf(temp);
        int index = currState.ordinal();
        count[index]+=1;
      }

      System.out.print(n + " ");
      for(i =0; i<8;i++){
        System.out.print(count[i] + " ");
      }
      System.out.println();
    }

  }
}
