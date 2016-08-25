package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by sumit.jha on 8/24/16.
 */
public class FACEFRND {

  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    SortedSet<Integer> bobFrnds = new TreeSet<Integer>();
    SortedSet<Integer> allFrnds = new TreeSet<Integer>();
    while(n--!=0){
      String temp[] = br.readLine().split(" ");
      bobFrnds.add(Integer.parseInt(temp[0]));

      for(int i=2;i<temp.length;i++){
        allFrnds.add(Integer.parseInt(temp[i]));
      }
    }
    allFrnds.removeAll(bobFrnds);
    System.out.println(allFrnds.size());


  }
}
