/**
 * Created by sumit.jha on 5/5/16.
 */


/*
* Give n print all possible combination of numbers which sums up to n;
* n = 5
* 1+1+1+1+1
* 1+1+1+2
* 2+2+1
* 3+2
* 4+1
* 1+3+1 and so on
* */
public class NumberPartiton {

  public static void printArray(int arr[] , int index){
    System.out.println();
    for(int i = 0; i<index; i++){
      System.out.print(arr[i]);
      System.out.print(" ");


    }
  }

  public  static void allPart(int n, int sum, int[] arr, int index){

    if(sum > n || index < 0){
      return;
    }

    if(sum == n ){
      printArray(arr, index);
      return;
    }

    for(int i=1;i<=n;i++){

      arr[index] = i;
      allPart(n,sum+i,arr,index+1);
    }


  }



  public static void main(String args[]){

    int n = 5;
    int[] arr = new int[n];
    allPart(n,0,arr,0);


  }

}
