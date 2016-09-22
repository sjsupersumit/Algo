package spoj;

import java.io.PrintWriter;
import java.util.Stack;

/**
 * Created by sumit.jha on 9/20/16.
 */
public class HISTOGRA {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int  n = in.nextInt();
        while (n!=0){

            long arr[] = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextLong();
            }
            out.println(getMaxHeight(arr));
            n = in.nextInt();






        }
    }


    static long getMaxHeight(long[] arr){

        Stack<Integer> s = new Stack<Integer>();
        long area=0,maxArea=0;
        int i=0;
        for(; i<arr.length;){
            if(s.empty() || arr[s.peek()] <= arr[i] ){
                s.push(i);
                i++;

            } else {
                int index = s.pop();
                int len = s.empty() ? i : (i - s.peek()-1) ;
                area = Math.max(area, arr[index]*len );

            }

        }

        while (!s.empty()){
            int index = s.pop();
            int len = s.empty() ? i : (i -  s.peek() -1) ;
            area = Math.max(area, arr[index]*len );
        }

        return area;
    }
}
