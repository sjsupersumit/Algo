import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sumit.jha on 6/24/16.
 */


/*
* Find triplets in sorted array which sums to zero
* */
public class ThreeSum {


  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp = br.readLine().split(" ");
    long nums[] = new long[temp.length];
    int index = 0, count=0, n = nums.length;

    for(String num: temp){
      nums[index++] = Long.parseLong(num);
    }

    for(int i=0; i<nums.length-3; i++){

        int j=i;
        int k=nums.length-1;

        while(j<=k){
          if(nums[i]+nums[j]+nums[k]==0){
           count++;
           j++;
            k--;
          }else if(nums[i]+nums[j]+nums[k]<0){
            j = j+1;
          }else{
            k = k-1;
          }
        }


    }

    System.out.print(count);



  }
}
