import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sumit.jha on 6/5/16.
 */
public class CountInversion {


  public int countInversions(ArrayList<Integer> a) {

    if(a == null || a.isEmpty()){
      return 0;
    }

    int index= 0;
    int arr[] = new int[a.size()];
    int buffer[] = new int[a.size()];
    for(Integer val : a){
      arr[index++] = val;
    }

    int inver = mergeSort(arr,buffer,0,a.size()-1);
    return inver;

  }

  public int mergeSort(int[] arr, int[] buff, int low, int high){
    int mid, invCount = 0;
    if(high > low){
      mid = (low + high)/2;
      invCount+= mergeSort(arr,buff,low,mid);
      invCount+=  mergeSort(arr,buff,mid+1,high);

      invCount+= merge(arr,buff,low, mid+1, high);

    }

      return invCount;
  }


  public int merge(int[] arr, int[] buff, int low, int mid, int high){
    int i,j,k;
    i = low;
    j = mid;
    k = low;
    int invC = 0;

    while(i <= mid-1 && j <= high){

      if(arr[i] <= arr[j]){
       buff[k++] = arr[i++];
      }else {

        buff[k++] = arr[j++];
        invC  += (mid-i);

      }
    }

    while(i <= mid-1){
      buff[k++] = arr[i++];


    }

    while (j <= high){
     buff[k++] = arr[j++];
    }

    //copy back
    for(i = low; i< high;i++){
      arr[i] = buff[i];
    }

return invC;

  }


  public static void main(String args[]){

    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(59,29));
    CountInversion countInversion = new CountInversion();
    int inversions  =  countInversion.countInversions(arr);
    System.out.println("No of Inversions in array are:-" + inversions);


  }
}
