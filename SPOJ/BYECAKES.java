package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/23/16.
 */
public class BYECAKES {
    public static void main(String args[]) throws Exception{

        int egg, flour,sugar,milk, reqEgg, reqFlour, reqSugar, reqMilk;
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        while (true){

            egg = in.nextInt();
            if(egg == -1 ) break;
            flour = in.nextInt();
            sugar = in.nextInt();
            milk = in.nextInt();
            reqEgg = in.nextInt();
            reqFlour = in.nextInt();
            reqSugar = in.nextInt();
            reqMilk = in.nextInt();


             double eggRatio = (egg*1.0)/reqEgg;
             double flourRatio = (flour*1.0)/reqFlour;
             double sugarRatio = (sugar*1.0)/reqSugar;
             double milkRatio = (milk*1.0)/reqMilk;
            


            //egg = 1, flour = 2, sugar= 3, milk=4

            int max,maxCakes;
          if(eggRatio>=flourRatio && eggRatio>=sugarRatio && eggRatio>=milkRatio){
              max = 1;
              maxCakes = (int)Math.ceil(eggRatio);
          } else if (flourRatio >= eggRatio && flourRatio>=sugarRatio && flourRatio>=milkRatio){
              max =2;
              maxCakes = (int)Math.ceil(flourRatio);

          } else if(sugarRatio >= eggRatio && sugarRatio>=milkRatio && sugarRatio>=flourRatio ){
              max = 3;
              maxCakes = (int) Math.ceil(sugarRatio);
          } else {
              max = 4;
              maxCakes = (int)Math.ceil(milkRatio);
          }


           out.printf("%d %d %d %d\n", reqEgg*maxCakes - egg, reqFlour*maxCakes -flour, reqSugar*maxCakes - sugar, reqMilk*maxCakes - milk  );





        }


    }
}
