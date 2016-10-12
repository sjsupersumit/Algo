package spoj;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by sumit.jha on 10/12/16.
 */
public class BUSYMAN {

    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int  t =in.nextInt();

        while (t--!=0){

            int n = in.nextInt();

            Event[] events = new Event[n];
            for(int i=0;i<n;i++){

                int st = in.nextInt();
                int et = in.nextInt();

                Event event = new Event(st,et);
                events[i] = event;

            }

            Arrays.sort(events);

            int count = 1;
            int prevTime = events[0].finish;

            for(int i=1; i<n;i++){

                if(events[i].start >= prevTime){
                    count++;
                    prevTime = events[i].finish;
                }
            }

            out.println(count);

        }



    }

    static class Event implements Comparable<Event>{
        int start;
        int finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Event o) {
            return this.finish - o.finish;
        }
    }
}
