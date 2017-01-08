package spoj;

import java.util.*;

/**
 * Created by sumit.jha on 1/8/17.
 */

/*
Gives TLE on spoj but same sol. in c++ stl is Accepted to leaving it here.

this code should also solve SPOJ TSHPATH which is same problem but with relaxed time limits.

For getting AC in java.. Implement own min Heap.. Java PQ doesnt cut it :(:(


TODO:  this problem is pain in ass to get AC in java..will try later

*/

public class SHPATH {

    private static final int MAX_CITIES = 10001;
    static Map<String, Integer> cityIdxMap;
    static List<MinHeapNode>[] adjList;

    public static int dijkstraShortestPath(int src, int dest, int totalVertex){

        int dist[] = new int[totalVertex+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<MinHeapNode> pq = new PriorityQueue<MinHeapNode>(totalVertex);

        //fill pq with all vertexes having src dist as 0 and others as INT_MAX
        for(int i=1; i<=totalVertex; i++){
            MinHeapNode node = new MinHeapNode(i, Integer.MAX_VALUE);

            if(i == src){
                node.distance = 0;
            }

            pq.offer(node);

        }

        while (!pq.isEmpty()){
            MinHeapNode currNode = pq.poll();

            for(int i=0; i<adjList[currNode.vertex].size(); i++)
            {
                MinHeapNode adjNode = adjList[currNode.vertex].get(i);
                if(pq.contains(adjNode) && dist[currNode.vertex]!=Integer.MAX_VALUE &&  dist[currNode.vertex] + adjNode.distance < dist[adjNode.vertex]){
                    dist[adjNode.vertex] =    dist[currNode.vertex] + adjNode.distance;

                     pq.remove(adjNode);
                     pq.add(new MinHeapNode(adjNode.vertex, dist[adjNode.vertex]));

                }
            }
        }

return dist[dest];

    }



    public static void main(String args[]) throws Exception{

        Reader in = new Reader();
        int t = in.nextInt();

        while (t--!=0){

            int V = in.nextInt();
            int v= V;
            cityIdxMap = new HashMap<String, Integer>(V);
            Integer cityIdx = 1;
             adjList = new List[V+1];

            for(int i=1; i<=V; i++){
                adjList[i] = new ArrayList<MinHeapNode>();
            }

            while (v--!=0){

                String cityName = in.readLine();
                cityIdxMap.put(cityName, cityIdx);


                int routes = in.nextInt();
                while (routes--!=0){

                    int vIdx = in.nextInt();
                    int dist = in.nextInt();

                    MinHeapNode node = new MinHeapNode(vIdx, dist);
                    adjList[cityIdx].add(node);

                }
                cityIdx++;
            }

            int queries = in.nextInt();
            String[] line;
            while (queries--!=0){

                line =  in.readLine().split(" ");
                int src = cityIdxMap.get(line[0]);

                int dest = cityIdxMap.get(line[1] );

                System.out.println( dijkstraShortestPath(src, dest, V));

            }
        }
    }


  static class MinHeapNode implements Comparable<MinHeapNode>{
        int vertex;
        int distance;




     MinHeapNode(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

      @Override
      public int compareTo(MinHeapNode o) {
          return this.distance - o.distance ;
      }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof MinHeapNode)) return false;

          MinHeapNode that = (MinHeapNode) o;

          return vertex == that.vertex;
      }

      @Override
      public int hashCode() {
          return vertex;
      }
  }
}
