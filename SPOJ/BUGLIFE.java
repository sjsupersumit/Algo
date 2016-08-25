package spoj;

import java.io.*;
import java.util.*;

/**
 * Created by sumit.jha on 8/24/16.
 */

/*
*
* Just chcek whether the graph is bipartite or not by checking 2-way coloring.
* */
public class BUGLIFE {

  enum Color{UNCOLORED(0), RED(1), BLUE(2);
    int id;

    Color(int id) {
      this.id = id;
    }
  }



  public static void main(String args[]) throws Exception {

    Reader in;
    PrintWriter out;

    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    in = new Reader ();
    out = new PrintWriter (System.out, true);
    int t = in.nextInt ();
    int scenario = 1;


    while (t-- != 0) {


      int bugs, interactions;
      //String[] temp = br.readLine().split(" ");
      bugs =  in.nextInt();
      interactions = in.nextInt();
      ArrayList<Integer> adjList[] = (ArrayList<Integer>[])new ArrayList[bugs];

      for(int i=0;i<bugs;i++){
        adjList[i] = new ArrayList<Integer>();
      }


      while(interactions--!=0){
        int u,v;

        u = in.nextInt() -1;
        v = in.nextInt() -1;
        adjList[u].add(v);
        adjList[v].add(u);

      }

       int[] nodeColors = new int[bugs];
      Arrays.fill(nodeColors, Color.UNCOLORED.id);
      boolean isBiparatite = true;

      for(int i=0;i<nodeColors.length;i++){
        if(nodeColors[i] == Color.UNCOLORED.id){
          if(!checkBiparatite(adjList, i, nodeColors)){
            isBiparatite = false;
            break;
          }
        }
      }

      out.printf("Scenario #%d:\n", scenario++);
      if(isBiparatite){
      out.println("No suspicious bugs found!");
      } else {
        out.println("Suspicious bugs found!");
      }

    }

  }

 static boolean checkBiparatite( ArrayList<Integer> adjList[], int source, int[]nodeColors){

   Queue<Integer> q = new LinkedList<Integer>();
   q.offer(source);
   nodeColors[source] = Color.RED.id;

   while (!q.isEmpty()){

     int curr = q.poll();
     for(int n: adjList[curr]){

       if(nodeColors[n] == nodeColors[curr]){
         return false;
       }

       if(nodeColors[n] == Color.UNCOLORED.id && nodeColors[curr] == Color.RED.id ){
         nodeColors[n] = Color.BLUE.id;
         q.add(n);
       }
       else if(nodeColors[n] == Color.UNCOLORED.id && nodeColors[curr] == Color.BLUE.id){
         nodeColors[n] = Color.RED.id;
         q.add(n);
       }


     }


   }




    return true;
  };



}

//copied ..
class Reader {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;
  public Reader(){
    din=new DataInputStream(System.in);
    buffer=new byte[BUFFER_SIZE];
    bufferPointer=bytesRead=0;
  }

  public Reader(String file_name) throws IOException{
    din=new DataInputStream(new FileInputStream(file_name));
    buffer=new byte[BUFFER_SIZE];
    bufferPointer=bytesRead=0;
  }

  public String readLine() throws IOException{
    byte[] buf=new byte[64]; // line length
    int cnt=0,c;
    while((c=read())!=-1){
      if(c=='\n')break;
      buf[cnt++]=(byte)c;
    }
    return new String(buf,0,cnt);
  }

  public int nextInt() throws IOException{
    int ret=0;byte c=read();
    while(c<=' ')c=read();
    boolean neg=(c=='-');
    if(neg)c=read();
    do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
    if(neg)return -ret;
    return ret;
  }

  public long nextLong() throws IOException{
    long ret=0;byte c=read();
    while(c<=' ')c=read();
    boolean neg=(c=='-');
    if(neg)c=read();
    do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
    if(neg)return -ret;
    return ret;
  }

  public double nextDouble() throws IOException{
    double ret=0,div=1;byte c=read();
    while(c<=' ')c=read();
    boolean neg=(c=='-');
    if(neg)c = read();
    do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
    if(c=='.')while((c=read())>='0'&&c<='9')
      ret+=(c-'0')/(div*=10);
    if(neg)return -ret;
    return ret;
  }

  private void fillBuffer() throws IOException{
    bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
    if(bytesRead==-1)buffer[0]=-1;
  }

  private byte read() throws IOException{
    if(bufferPointer==bytesRead)fillBuffer();
    return buffer[bufferPointer++];
  }

  public void close() throws IOException {
    if(din==null) return;
    din.close();
  }
}
