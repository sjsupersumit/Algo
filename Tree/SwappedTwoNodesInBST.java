/**
 * Created by sumit.jha on 5/17/16.
 */

/*
* Given a BST which has its 2 node swapped, restore the BST
*
* The idea is that inorder traversal of normal bst is sorted. in this case the inorder traversal will contain at max
* 2 position where data wont be in increasing oder. For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}.
 The inorder traversal of the given tree is 3 25 7 8 10 15 20 5
*
* if the swapped node are adjacent 2 each other then there will be
* only one position where sorted position wont be followed For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20
* 25}.
  The inorder traversal of the given tree is 3 5 8 7 10 15 20 25
*  so just find those position and swap
*
*
* */
public class SwappedTwoNodesInBST {

  /* This function does inorder traversal to find out the two swapped nodes.
 It sets three pointers, first, middle and last.  If the swapped nodes are
 adjacent to each other, then first and middle contain the resultant nodes
 Else, first and last contain the resultant nodes
 */
  private void fixBstUtil(TreeNode root, RefObject refObject){

    if(root == null){
      return;
    }

    //recur for left
    fixBstUtil(root.left, refObject);

    //check violation of bst
    if( refObject.prev!=null && root.data < refObject.prev.data){

      //check if first violation
      if(refObject.first == null){
        refObject.first = refObject.prev;
        refObject.middle = root;
      } else{
        refObject.last = root;
      }

    }

    refObject.prev = root;

    //recur right
    fixBstUtil(root.right, refObject);
  }

  public void fixBst(TreeNode root){
    if(root == null )
      return;

    RefObject refObject = new RefObject();

    fixBstUtil(root,refObject);
    if(refObject.first!=null && refObject.last!=null){

      int temp = refObject.first.data;
      refObject.first.data = refObject.last.data;
      refObject.last.data = temp;
    } else if (refObject.first!=null && refObject.middle!=null){

      int temp = refObject.first.data;
      refObject.first.data = refObject.middle.data;
      refObject.middle.data = temp;
    }


  }

  public static void main(String args[]){

     /*   6
        /  \
       10    2
      / \   / \
     1   3 7  12
     10 and 2 are swapped
    */

    TreeNode root = new TreeNode(6);
    root.left        = new TreeNode(10);
    root.right       = new TreeNode(2);
    root.left.left  = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(12);
    root.right.left = new TreeNode(7);

    root.inOrderTraversal(root);
    System.out.println("Fixing Tree...");
    SwappedTwoNodesInBST swappedTwoNodesInBST = new SwappedTwoNodesInBST();
    swappedTwoNodesInBST.fixBst(root);
    root.inOrderTraversal(root);



  }
}

//for mimicKing pass by reference
class RefObject{

  TreeNode prev , first,middle,last;

  public RefObject() {
    prev = first = middle = last = null;
  }
}


