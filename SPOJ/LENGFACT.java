package spoj;

/**
 * Created by sumit.jha on 1/30/17.
 */
public class LENGFACT {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        int t = in.nextInt();

        while (t--!=0){
            long n = in.nextLong();

            //kamentky formula .. this thing can be derived from stirling approximation for num n there are log(n) + 1 digit so this is very nice approximation which accurately works till 7*10^7
            long val = (long)( (Math.log10(2*Math.PI*n)/2) + n*(Math.log10(n)- Math.log10(Math.E))/Math.log10(10)) + 1;

            System.out.println(val);


        }
    }
}
