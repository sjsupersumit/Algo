import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by sumit.jha on 6/6/16.
 */

/*
*You are given an unweighted, undirected graph. Write a program to check if it's a tree topology.
* */

public class SpojPT07Y {

  private static boolean visited[];
  private static int nodeCount = 0;
  private static ArrayList<Integer>[] adjList;


  public static void main(String ags[]) throws IOException {

    int n, m, i, j, k;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer("");

    String[] temp = br.readLine().split(" ");
    //n node m edges

    n = Integer.parseInt(temp[0]);
    m = Integer.parseInt(temp[1]);

    adjList = new ArrayList[n];
    for (i = 0; i < n; i++) {
      adjList[i] = new ArrayList<Integer>();
    }


    for (i = 0; i < m; i++) {
      temp = br.readLine().split(" ");
      int u = Integer.parseInt(temp[0]) - 1;
      int v = Integer.parseInt(temp[1]) - 1;

      adjList[u].add(v);
      adjList[v].add(u);

    }

    visited = new boolean[n];
    nodeCount = 0;

    if (dfs(0, -1) && nodeCount == n) {
      System.out.print("YES");
    } else {
      System.out.print("NO");
    }
  }

  public static boolean dfs(int root, int previous) {

    if (visited[root]) {
      return false;
    }
    visited[root] = true;
    nodeCount++;

    for (int i : adjList[root]) {
      if (previous == i)
        continue;

      if (!dfs(i, root)) return false;
    }
    return true;
  }

}
