package RandomAlgo;

/**
 * Created by sumit.jha on 12/4/16.
 *
 *
 * Since I've seen many people struggle with this question in interview, I set out to solve this myself and I still fail to understand why so many people even
 * having tons of experience in Industry fail in this simple task.
 */
public class PrintAllSubSets {

   static int arr[] = {1,2,3};

    private void printSubSets(int[] op, int idx, int opIdx){

        if(idx == op.length){
            printOutput(op, opIdx);
            return;
        }

        op[opIdx] = arr[idx];
        printSubSets(op, idx+1, opIdx+1);
        printSubSets(op, idx+1, opIdx);



    }

   private void printOutput(int arr[], int idx){


       if(idx==0){
           System.out.print("Empty Subset");
       }

        for(int i=0 ; i<idx; i++){
            System.out.print(arr[i] + " " );
        }
        System.out.println();
    }

    public static void main(String ...args){

        int[] op = new int[arr.length];
        PrintAllSubSets printAllSubSets = new PrintAllSubSets();
        printAllSubSets.printSubSets(op,0,0);



    }
}
