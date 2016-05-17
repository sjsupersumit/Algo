/**
 * Created by sumit.jha on 5/17/16.
 */

/*
* Given a pre order traversal of BST, Construct BST.
*
* */
public class BstFromPreOrder {

  public TreeNode createBST(int[] pre, int left, int right) {

    if (left >= right)
      return null;

    TreeNode root = new TreeNode(pre[left]);

    int i = left + 1;
    while (i < pre.length && pre[i] < root.data) {
      i++;
    }

    root.left = createBST(pre, left + 1, i);
    root.right = createBST(pre, i, right);

    return root;


  }


  public static void main(String args[]) {

    int pre[] = {2, 1, 0, 4, 3, 5};
    int len = pre.length;
    BstFromPreOrder bstFromPreOrder = new BstFromPreOrder();
    TreeNode root = bstFromPreOrder.createBST(pre, 0, len);
    TreeNode.inOrderTraversal(root);

  }
}
