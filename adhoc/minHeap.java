import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by sumit.jha on 5/7/16.
 */

/*
*
* Given N files having millions of integer,  return top 10 ints
*
* the code uses priority queue as heap. This prolem could also be done  with TreeSet using pollFirst method
* */
public class minHeap {

  public static final int MAX_TOP_NUMBERS = 10;

  public static void main(String args[]){

    //java heap are by default min heap so no need to pass a comparator
    PriorityQueue<Integer> minPriorityQ = new PriorityQueue<>();
    File dir = new File("/Users/sumit.jha/Document/projectEuler/temp");
    File[] listOfFiles = dir.listFiles();

    if(listOfFiles!=null) {
      for (File file : listOfFiles) {
        try {
          if (file.isFile()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
              int val = sc.nextInt();
              // Just keep adding to min heap, smallest value which is the root will always gets replaced
              if(minPriorityQ.size() < MAX_TOP_NUMBERS){
                minPriorityQ.offer(val);
              } else {
                if(val > minPriorityQ.peek()){
                  //removes the smallest element i.e root of heap
                  minPriorityQ.poll();
                  minPriorityQ.offer(val);
                }
              }

            }
            sc.close();
          }
        } catch (FileNotFoundException fExp) {
          fExp.printStackTrace();
        }
      }

    }

    //Note just traverse the heap to get 10 max numbers,  at any point of time heap size will be atmost 10

    while(!minPriorityQ.isEmpty()){
      int value = minPriorityQ.poll();
      System.out.print(value + " ");
    }


  }
}
