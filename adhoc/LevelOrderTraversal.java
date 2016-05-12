import java.util.*;
import java.util.LinkedList;

/**
 * Created by sumit.jha on 5/5/16.
 */
public class LevelOrderTraversal {

  public static void printLevelOrder(TreeNode root){

    if(root == null){
      return ;
    }

    Queue<TreeNode> levelQ = new LinkedList<TreeNode>();
    levelQ.add(root);
    while(!levelQ.isEmpty()){

      int count = levelQ.size();
      while((count--) !=0){

        TreeNode node = levelQ.remove();
        System.out.print(node.data + " ");
        if(node.left!=null){
          levelQ.add(node.left);
        }
        if(node.right!=null){
          levelQ.add(node.right);
        }

      }
      System.out.println();

    }

  }


  public static void zigZagTraversal(TreeNode root){
    if(root == null){
      return ;
    }

    boolean leftToRight = true;
    Stack<TreeNode> currLevel = new Stack<>();
    Stack<TreeNode> nextLevel = new Stack<>();
    currLevel.add(root);
    while(!currLevel.isEmpty()){
      TreeNode node = currLevel.pop();
      System.out.print(node.data + " ");

      if(leftToRight){
        if(node.left!=null)
          nextLevel.push(node.left);
        if(node.right!=null)
          nextLevel.push(node.right);

      }else {
        if(node.right!=null)
          nextLevel.push(node.right);
        if(node.left!=null)
          nextLevel.push(node.left);

      }

      if(currLevel.isEmpty()){
        System.out.println();
        leftToRight = !leftToRight;
       Stack<TreeNode> temp  = currLevel;
        currLevel = nextLevel;
        nextLevel = temp;
      }
    }


  }



  public static void main(String[] args){

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left =  new TreeNode(6);
    root.right.right =  new TreeNode(0);

    printLevelOrder(root);
    System.out.println();
    zigZagTraversal(root);
  }
}
