package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sumit.jha on 8/30/16.
 */
public class ANARC05B {

    public static void main(String args[]) throws Exception{
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        boolean readIp = true;

        while (readIp){
            int l1 = in.nextInt();
            if(l1==0){
                readIp = false;
                break;
            }
            int arr1[] = new int[l1];
            for(int i=0;i<l1;i++){
                arr1[i] = in.nextInt();
            }
            int l2 = in.nextInt();
            int arr2[] = new int[l2];
            for(int i=0;i<l2;i++){
                arr2[i] = in.nextInt();
            }
            //smaller one
            int len = l1 > l2 ? l2:l1 ;
            long res=0,sum1=0,sum2=0;
            int i=0,j=0;
            //remember array is strictly increasing

            while(i < l1 && j<l2){

                if(arr1[i] < arr2[j]){

                    sum1+= arr1[i++];

                } else if (arr1[i] > arr2[j]) {
                    sum2 += arr2[j++];
                }else{
                    //eq case
                    res+= sum1 > sum2 ? sum1:sum2;
                    sum1=sum2=0;
                    res+=arr1[i++];
                    j++;


                }

            }

            //check remaining elements, at any time only 1 while will get
            while (i < l1){
                sum1+= arr1[i++];
            }

            while (j < l2){
                sum2+= arr2[j++];
            }

            res+= sum1 > sum2 ? sum1:sum2;
            out.println(res);





        }


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
