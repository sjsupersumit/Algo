package spoj;

import java.io.PrintWriter;

/**
 * Created by sumit.jha on 9/22/16.
 */
public class DIEHARD {

    public static void  main(String args[]) throws Exception{
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        while(t--!=0){
            int h = in.nextInt() + Place.AIR.health;
            int a = in.nextInt() + Place.AIR.armour;
            int steps = 1;
            Place currPlace = Place.AIR;

            //adopt greedy optimize which ever is less if h go to Water if ar go to fire

            while(h>0 && a>0){

                if(currPlace != Place.AIR){
                    h+= Place.AIR.health;
                    a+= Place.AIR.armour;
                    currPlace = Place.AIR;
                    steps+=1;

                } else {

                    if(a<=10 && h>=20 ){

                    currPlace = Place.FIRE;
                        h+= Place.FIRE.health;
                        a+= Place.FIRE.armour;
                        steps+=1;

                    } else {
                        currPlace = Place.WATER;
                        h+= Place.WATER.health;
                        a+= Place.WATER.armour;
                        steps+=1;
                    }



                }





            }

            steps-=1;
            out.println(steps);



        }
    }

  private enum Place{

      AIR(2,3,'a'),
      WATER(-10,-5,'w'),
      FIRE(5,-20,'f');



        int armour;
        int health;
        char name;

        Place(int armour, int health, char name) {
            this.armour = armour;
            this.health = health;
            this.name = name;
        }
    }
}
