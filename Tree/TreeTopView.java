import java.util.*;
import java.util.LinkedList;

/**
 * Created by sumit.jha on 5/15/16.
 */

/*
* Prints the top view of tree
*
* the idea is to just asssign the node a horizontal distance (the first node of unique hd should be in top view)
*
* i/p =
*      1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is

1 2 3 4 7
*
*
* */


public class TreeTopView {

  class QItem{
    TreeNode node;
    int hd;

    public QItem(TreeNode node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  public void printTopView(TreeNode root){

    if(root == null){
      return;
    }

    Queue<QItem> itemQueue = new LinkedList<>();
    HashSet<Integer> hdSet = new HashSet<>();
    itemQueue.add(new QItem(root, 0));

    //normal Bfs

    while(!itemQueue.isEmpty()){

     QItem currQItem = itemQueue.remove();
     int hd = currQItem.hd;
     TreeNode currNode = currQItem.node;

     if(!hdSet.contains(hd)){
       System.out.print(currNode.data + "\t");
       hdSet.add(hd);
     }

      if(currNode.left!=null){
        itemQueue.add(new QItem(currNode.left, hd-1));   //subtract 1 from hd on left
      }

      if(currNode.right!=null){
        itemQueue.add(new QItem(currNode.right, hd+1));   //Add 1 to hd for right;
      }


    }
  }


  public static void main(String args[]){

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right =   new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(6);

    TreeTopView treeTopView = new TreeTopView();
    treeTopView.printTopView(root);

  }

}
