import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sumit.jha on 6/5/16.
 */

/*
* Given array with +/- numbers, return max product of a subarray
* */
public class MaxProductSubArray {

  public int maxProduct(final List<Integer> a) {

    if(a==null || a.isEmpty()){
      return 0;
    }

    int max_ending_here = 1;
    int min_ending_here = 1;
    int max_so_far = 1;
    int zeroCnt= 0;
    int negCount =0 ;
    //check all zero()

    for(int i : a){
      if(i<0){
        negCount++;
      } else if(i == 0){
        zeroCnt++;
      }
    }

    if(zeroCnt == a.size() || negCount == 1){
      return 0;
    }




    for(int i=0;i<a.size();i++){



      if (a.get(i) > 0)
      {
        max_ending_here = max_ending_here*a.get(i);
        min_ending_here = Math.min(min_ending_here * a.get(i), 1);
      } else if (a.get(i) == 0)
      {
        max_ending_here = 1;
        min_ending_here = 1;
      }  else{
        int temp = max_ending_here;
        max_ending_here = Math.max(min_ending_here * a.get(i), 1);
        min_ending_here = temp * a.get(i);
      }

      // update max_so_far, if needed
      if (max_so_far <  max_ending_here)
        max_so_far  =  max_ending_here;
    }


    return max_so_far;
  }

  public static void main(String args[]){

    MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 0, 0, -3, -2, 0, 1, 0, 0, 0, 0, 0, -2, 0, 0, 0, 3, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, -1, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, -2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ));
    System.out.print(maxProductSubArray.maxProduct(a));


  }
}

