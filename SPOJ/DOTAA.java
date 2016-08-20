package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sumit.jha on 8/20/16.
 */
public class DOTAA {

  static class PQsort implements Comparator<Integer> {

    public int compare(Integer one, Integer two) {
      return two - one;
    }
  }

  public static void main(String args[]) throws Exception{

    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    while(n--!=0){

      boolean canThey = true;
      String[] temp = br.readLine().split(" ");
      int h = Integer.parseInt(temp[0]);
      int t = Integer.parseInt(temp[1]);
      int d = Integer.parseInt(temp[2]);

      //max heap
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,new PQsort());
      for(int i =0;i<h;i++)
      {
        pq.offer(Integer.parseInt(br.readLine()));
      }
      int md = d*t;

      while(md > 0 && canThey){

        int ele = pq.poll();
        if(ele <= d){
          canThey = false;

        } else {

          int mulFactor = ele % d;
          mulFactor = mulFactor == 0 ? (ele /d -1) : (ele/d);
          ele = ele  - ( d * mulFactor) ;
          pq.offer(ele);
          md -= d*mulFactor;

        }
      }

      if(canThey){
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    //  br.readLine();


    }

  }
}
