package spoj;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by sumit.jha on 10/9/16.
 */
public class HACKRNDM {

    public static void main(String[] args) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        int ans=0;
        Arrays.sort(arr);

        for(int i =0, j=0; j<n ; ){

        if(arr[j] - arr[i] == k){
            ans++;
            i++;            //nums are distinct
            j++;
        } else if(arr[j] - arr[i] < k  ){


            j++;
        }else{
            i++;
        }


        }

        out.println(ans);
    }
}
