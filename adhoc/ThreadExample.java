/**
 * Created by sumit.jha on 10/19/15.
 */
public class ThreadExample  {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        for(int i=0; i<1000000; i++){
            new Thread("" + i){

                public void run(){
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }
}
