import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sumit.jha on 5/9/16.
 */



/*
* Given an array of strings, find if the strings can be chained to form a circle
*
* Input: arr[] = {"geek", "king"}
* Output: Yes, the given strings can be chained.
*
* Input: arr[] = {"geek", "king"}
* Output: Yes, the given strings can be chained.
*
*
* The idea is to create a directed graph of all characters and then find if their is an eulerian circuit in the graph or not.
* If there is an eulerian circuit, then chain can be formed, otherwise not.
* A directed graph has eulerian circuit only if in degree and out degree of every vertex is same,
* and all non-zero degree vertices form a single strongly connected component.
* */
public class EulerCircuit {

  public static final int TOTAL_CHARS = 26;

  boolean canBeChained(List<String> stringList){
    if(stringList == null || stringList.isEmpty())
       return false;

    Graph graph = new Graph(TOTAL_CHARS);
    for(String s: stringList){
      graph.addEdge(s.charAt(0)-'a', s.charAt(s.length() -1 )-'a');
    }

    return graph.isEulerianCycle();


  }


  public static void main(String[] args){
    List<String> strList = Arrays.asList("abg","geek", "king", "gramp" , "pot");
    EulerCircuit eu = new EulerCircuit();
    if( eu.canBeChained(strList)){
      System.out.println("Yes");
    }
    else
      System.out.println("NO");

  }
}
