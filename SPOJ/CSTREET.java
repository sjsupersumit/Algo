package spoj;


import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by sumit.jha on 9/26/16.
 */
public class CSTREET {

    static final int MAX = 1002;
    static Node edgeList[];
    static int parent[] = new int[MAX];


    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int t = in.nextInt();
        while (t-- != 0) {

            int price = in.nextInt();
            int vertices = in.nextInt();
            int edge = in.nextInt();
            int idx = 0;
            edgeList = new Node[edge];
            for (int i = 1; i <= vertices; i++) {
                parent[i] = i;
            }

            while (idx < edge) {

                int src = in.nextInt();
                int dest = in.nextInt();
                int cost = in.nextInt();
                Node node = new Node(src, dest, cost);

                edgeList[idx] = node;
                idx++;
            }

            Arrays.sort(edgeList);
            int edgeCount = 0;


            long totalCost = 0;
            idx = 0;

            while (edgeCount < vertices-1 ) {
                Node curEdge = edgeList[idx];
                if (!checkCycle(curEdge.src, curEdge.dest)) {

                    edgeCount++;
                    totalCost += curEdge.cost;

                }
                idx++;

            }
            out.println(totalCost * price);
        }
    }

    
    static boolean checkCycle(int src, int dest) {

        int srcRoot = findParent(src);
        int destRoot = findParent(dest);
        if (srcRoot == destRoot ) {
            return true;
        }
        parent[destRoot] = srcRoot;
        return false;
    }

    static int findParent(int i) {

        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }


    static class Node implements Comparable<Node> {

        int src;
        int dest;
        int cost;

        public Node(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
