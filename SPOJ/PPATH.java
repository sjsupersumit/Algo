package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumit.jha on 9/1/16.
 */
public class PPATH {

    public static final int MAX_LIMIT = 10000;
    static boolean prime[] = new boolean[MAX_LIMIT];
    // static boolean visited[] = new boolean[MAX_LIMIT];

    @SuppressWarnings("unchecked")
    private static HashSet<Integer> adjList[] = new HashSet[MAX_LIMIT];


    static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i < Math.sqrt(MAX_LIMIT); i++) {
            if (prime[i]) {
                for (int j = i * i; j < MAX_LIMIT; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 0; i < MAX_LIMIT; i++) {
            adjList[i] = new HashSet<Integer>();
        }


        for (int i = 1000; i <= 9999; i++) {

            if (!prime[i]) continue;

            for (int idx = 0; idx < 4; idx++) {


                int start = (idx == 0) ? 1 : 0;
                while (start <= 9) {
                    char[] temp = String.valueOf(i).toCharArray();
                    temp[idx] = Character.forDigit(start, 10);

                    int tempNum = Integer.parseInt(new String(temp));
                    if (prime[tempNum] && (tempNum >= 1000 && tempNum <= 9999) && tempNum != i) {
                        adjList[i].add(tempNum);
                        adjList[tempNum].add(i);
                    }
                    start++;
                }


            }


        }

    }

    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        sieve();

        int t = in.nextInt();
        while (t-- != 0) {

            int num1 = in.nextInt();
            int num2 = in.nextInt();
            boolean visited[] = new boolean[MAX_LIMIT];
            //Arrays.fill(visited, false);
            PPATH ppath = new PPATH();

            int steps = ppath.findSteps(num1, num2, 0, visited);

            if (steps == -1) {
                out.println("Impossible");
            } else {
                out.println(steps);
            }

        }

    }


    int findSteps(int num1, int num2, int steps, boolean visited[]) {

        if(num1 == num2) return 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num1);

        while(!q.isEmpty()){
            int cnt = q.size();
        steps++;
            while(cnt--!=0){
                int curr = q.poll();
                visited[curr] = true;

                for(int i : adjList[curr]){

                    if(i == num2){
                        return steps;
                    }
                    if(!visited[i]){
                        q.offer(i);
                    }
                }

            }

        }
        return -1;
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


