package spoj;

/**
 * Created by sumit.jha on 1/25/17.
 */
public class RPLC {


    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        int t = in.nextInt();
        int T = t;
        while(t--!=0){
            int n = in.nextInt();
            long sum=0;
            long ans=0;

            for(int i=0; i<n;i++){
                int k = in.nextInt();

                sum+=k;
                if(sum < ans){
                    ans = Math.min(ans,sum);

                }
            }

             ans= Math.abs(ans)+1;
             System.out.printf("Scenario #%d: %d\n",T-t, ans );


        }

    }


}
