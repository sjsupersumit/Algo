package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumit.jha on 9/6/16.
 */
public class FIBOSUM {

    public static final int MOD = 1000000007;
    public static final int LIMIT = 1000000002;
    public static Map<Integer,Long> fib = new HashMap<Integer,Long>();




    public static void  main(String args[]) throws Exception{

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out,true);



        int t = in.nextInt();
        while(t--!=0){

            int n = in.nextInt();
            int m = in.nextInt();
            long pre = 0l;
            if(n == 0){
                n =1;
            }
pre = getSum(m-1) - getSum(n-2);

            if(pre < 0){
                pre = (pre%MOD + MOD)%MOD;
            }



            System.out.println(pre);

        }


    }

    //fib(i) = fib( (i+1)/2) * fib(i/2) + fib(n-1)/2) * fib(n-2)/2

 static long getFibo(int n){


        if(n<2) return 1l;

        if(fib.get(n)!=null) return fib.get(n);

        long val = ( getFibo((n+1)/2) * getFibo(n/2) + getFibo((n-1)/2) * getFibo((n-2)/2) ) % MOD  ;
        fib.put(n,val);
        return val;
    }


    static long getSum(int i){
        return getFibo(i+2) -1;
    }
}


class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9')
            ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) return;
        din.close();
    }
}



