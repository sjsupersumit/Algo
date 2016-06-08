import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


/**
 * Created by sumit.jha on 6/7/16.
 */
public class SpojBYTESM2 {


  public static void main(String args[]) throws IOException{

    int t,r,c,i,j;
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    String[] temp; // = br.readLine().split(" ");
    StringTokenizer st;
    t = parseInt(br.readLine());
    int mat[][];
     while(t-->0){


       st = new StringTokenizer(br.readLine());
       r =  parseInt(st.nextToken());
       c = parseInt(st.nextToken());

       mat = new int[r][c];

       for(i=0;i<r;i++){

         for(j=0;j<c;j++){

           if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
           mat[i][j] = parseInt(st.nextToken());

         }
       }

       for(i= 1; i<r;i++){
         for(j=0; j<c;j++){

           int above = checkBound(i-1,j,r,c) ? mat[i-1][j]: 0;
           int leftdia = checkBound(i-1,j-1,r,c) ? mat[i-1][j-1]: 0;
           int rightdia = checkBound(i-1, j+1,r,c) ? mat[i-1][j+1]: 0;

           mat[i][j] = mat[i][j] + Math.max( Math.max(above,leftdia), rightdia);

         }
       }


       int max = Integer.MIN_VALUE;

       for(i=0;i<c;i++){
         if(mat[r-1][i] > max){
           max = mat[r-1][i];
         }
       }
      System.out.println(max);
      System.out.flush();
     }

  }

  private static boolean checkBound(int x,int y,int r,int c){

    if(x<0 || y <0)
      return false;

    if(x>=r || y>=c)
       return false;

    return true;
  }
}
