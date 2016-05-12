/**
 * Created by sumit.jha on 5/8/16.
 */
public class Count1 {

   static int arr[][] = {{1,0,0,1,0,0}, {0,0,1,0,1,0}, {0,0,0,0,0,0}, {1,1,0,0,0,0},{1,1,1,0,0,0}, {0,1,0,1,0,0} };


  static void markZero(int i, int j,int n){
    if(i <0 || j <0 )
      return;

    if(i>=n || j>= n)
      return;

    if(arr[i][j] ==1){
      arr[i][j] = 0;

      markZero(i,j-1,n);
      markZero(i,j+1,n);
      markZero(i-1,j,n);
      markZero(i+1,j,n);
      markZero(i-1,j-1,n);
      markZero(i-1,j+1,n);
      markZero(i+1,j-1,n);
      markZero(i+1,j+1,n);
    }

    return ;
  }

  public static  void main(String args[]){
    int i,j,k,ans=0,n=6;

    int count = 0;

    for(i=0;i<n;i++){
      for(j=0;j<n;j++){
        if(arr[i][j] == 1){
          count++;
          markZero(i,j,n);

        }
      }
    }

    System.out.print(count);


  }
}
