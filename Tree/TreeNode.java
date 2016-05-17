import java.util.Stack;

/**
 * Created by sumit.jha on 5/5/16.
 */
class TreeNode
{
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }

//Iterative inOrder order traversal
  public void inOrderTraversal(TreeNode root){

    if(root == null){
      return;
    }
    System.out.println("Printing InOrder Traversal of Tree.....\n");
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;

    while(node!=null){
      stack.push(node);
      node = node.left;
    }

    while (!stack.isEmpty()){

      node = stack.pop();
      System.out.print(node.data + "\t");

      if(node.right!=null){
        node = node.right;
        while (node!=null){
          stack.push(node);
          node = node.left;
        }
      }
    }

  }
}
