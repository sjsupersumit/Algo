package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/14/16.
 */
public class MISERMAN {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        int m = in.nextInt();

        int mat[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int above = checkBound(i - 1, j, n, m) ? mat[i-1][j]: Integer.MAX_VALUE;
                int leftdia = checkBound(i-1,j-1,n,m) ? mat[i-1][j-1]: Integer.MAX_VALUE;
                int rightdia = checkBound(i-1, j+1,n,m) ? mat[i-1][j+1]: Integer.MAX_VALUE;

                mat[i][j] = mat[i][j] + Math.min( Math.min(above, leftdia), rightdia);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            if(mat[n-1][i] < min){
                min = mat[n-1][i];
            }
        }
        out.println(min);
    }


    private static boolean checkBound(int x,int y,int r,int c){

        if(x<0 || y <0)
            return false;

        if(x>=r || y>=c)
            return false;

        return true;
    }
}
