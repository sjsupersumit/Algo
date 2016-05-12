/**
 * Created by sumit.jha on 5/9/16.
 */

import java.util.*;
import java.util.LinkedList;

public class Graph {

  private int V; //no. of vertices
  private LinkedList<Integer> adj[];   //adjacency list
  private int in[];    //for maintaining indegree

  public Graph(int v) {
    V = v;
    adj = new LinkedList[V];
    in = new int[V];
    for(int i=0; i < V; i++){
      adj[i] = new LinkedList<Integer>();
      in[i] = 0;
    }
  }

//directed graph so 1 edge
  void addEdge(int v, int w){
    adj[v].add(w);
    //adj[w].add(v);
    in[w]+=1;
  }


/*
* Does the DFS Traversal and mark visited array Accordingly
* */
  void DFSUtil(int v, Boolean visited[]){

    visited[v] = true;
    System.out.print("[" + v + "]->");

    int n;
    Iterator<Integer> i = adj[v].iterator();
    while (i.hasNext())
    {
      n = i.next();
      if (!visited[n])
        DFSUtil(n,visited);
    }

  }

  /*
   * Return True if graph is strongly connected
   * */
  boolean isGraphConnected() {
    Boolean visited[] = new Boolean[V];
    for (int i = 0; i < V; i++)
      visited[i] = false;


    DFSUtil(0, visited);

    // If DFS traversal doesn't visit all vertices, then return false.
  for (int i = 0; i < V; i++)
      if (!visited[i])
      return false;

    return true;

  }

  /* This function returns true if the directed graph has an eulerian
      cycle, otherwise returns false
  */
  Boolean isEulerianCycle()
  {
    // Check if all non-zero degree vertices are connected
    if (!isGraphConnected())
      return false;

    // Check if in degree and out degree of every vertex is same
    for (int i = 0; i < V; i++)
      if (adj[i].size() != in[i])
        return false;

    return true;
  }

}

