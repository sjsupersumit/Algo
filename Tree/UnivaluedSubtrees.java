import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by sumit.jha on 6/24/16.
 */


/*
* In this problem you are given a tree of N nodes.
* Each of the nodes will be numbered from 0 to N-1 and each node i(node numbered i) is associated with a value vi.
* Assume the tree is rooted at node 0.A node Y is said to be desecented of node X if X occurs in the path from node Y to node 0.
 * A subtree rooted at node X is defined as set of all nodes whchich are decendants of X and edges Between them( including X).
 * A subtree is called univalued if the value of all the nides in the subtree are equal.
 * Now give the tree and the values associated with nodes in the tree .
 * You are required to find the number of rooted univalued subtrees in the tree.
 *
 * Input:
 *
 *First line contains an interger N which is the number o0f nodes in the tree .
 * Next N lines contain an integer each which are values associated with nodes
 * i.e, ith line contains the value associated  with node i-1.Next N-1 lines give the information of edges in the tree .
 * Each line contains two Space separated integers X and Y which says that there is an edge between node X and node Y.
 *
 * Output:
 *
* Given the input of tree in above format you have to print the number of Univalued subtrees that are contained in the given tree.
* You just have tp print a single integer.
*
* Sample Input:
* 5 0 0 1 1 1 0 1 0 2 2 3 2 4
*
* Sample Output:
* 4
*
* Explanation:
* the subtree rooted at node 0 is not univalued because it contains node 1 which has value 0 and node 2 which has value 1.
* But subtrees rooted at node 1,2,3,4 all are univalued.
* */
public class UnivaluedSubtrees {


  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
   TreeNode nodes[] = new TreeNode[n];

    for(int i=0;i<n;i++){
      int data = Integer.parseInt(br.readLine());
      nodes[i] = new TreeNode(data);
    }

    for(int i=0; i<n-1;i++){
      String[] temp = br.readLine().split(" ");

      int x = Integer.parseInt(temp[0]);
      int y = Integer.parseInt(temp[1]);

      if(nodes[x].left == null){
        nodes[x].left = nodes[y];
      } else {
        nodes[x].right = nodes[y];
      }

    }

    UnivaluedSubtrees univaluedSubtrees = new UnivaluedSubtrees();
   int count =univaluedSubtrees.getAns(nodes[0]);
   System.out.print(count);

  }


  int getAns(TreeNode node){
    Count c= new Count();
    c.count=0;

    getUnivaluedTree(node,c);
    return c.count;

  }

  boolean getUnivaluedTree(TreeNode node, Count c){

    if(node == null){
      return true;
    }

    boolean left = getUnivaluedTree(node.left,c);
    boolean right = getUnivaluedTree(node.right,c);

    if(left == false || right == false)
      return false;

    if (node.left != null && node.data != node.left.data) {
      return false;
    }

    if (node.right != null && node.data != node.right.data) {
      return false;

    }

    c.count++;
    return true;

  }


class Count{
  int count;
}

  static class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right =null;
    }
  }
}
