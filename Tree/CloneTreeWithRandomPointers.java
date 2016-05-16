/**
 * Created by sumit.jha on 5/15/16.
 */

/*
* Given a tree with a extra random pointer which can point to any node(or can be null as well, Clone it)
*
* We are modifying the orignal tree in this approach, if that wasnt allowed than it cane be done iwth using a
* hashtable for maintaing the random pointers
*
* In this approach, A new clone node will be inserted in tree just after the original node and in later steps cloned
* tree will be seprated
* */

class RandomTreeNode {

  int data;
  RandomTreeNode left;
  RandomTreeNode right;
  RandomTreeNode random; //can point anywhere

  public RandomTreeNode(int data) {
    this.data = data;
    left = random = right = null;
  }
}



public class CloneTreeWithRandomPointers {

  

  //prints tree in preorder along with its random node in [].
  public void inorderTraversal(RandomTreeNode root){

    if(root == null)
      return;

    inorderTraversal(root.left);
    System.out.print(root.data);
    if(root.random!=null){
      System.out.print("[" + root.random.data + "]");
    } else{
      System.out.print("[NULL]");
    }
    System.out.print("\t");

    inorderTraversal(root.right);

  }


  public RandomTreeNode clone(RandomTreeNode root){

    if(root == null)
      return null;
      RandomTreeNode cloneNode = cloneLRChilds(root);
      copyRandomNode(root);
      restoreOrignalTree(root, cloneNode);
    return cloneNode;
  }
  // This function creates new nodes cloned tree and puts new cloned node
// in between current node and it's left child
  public RandomTreeNode cloneLRChilds(RandomTreeNode root){
    if(root == null)
       return null ;

    RandomTreeNode left = root.left;
    root.left = new RandomTreeNode(root.data);
    root.left.left = left;

    if(left!=null){
      left.left = cloneLRChilds(left);
    }
    root.left.right = cloneLRChilds(root.right);
    return root.left;

  }

  public void copyRandomNode(RandomTreeNode root){

    if(root==null)
      return;

    if(root.left!=null){
      root.left.random = root.random;
      copyRandomNode(root.left.left);
    }

    copyRandomNode(root.right);




  }

  public void restoreOrignalTree(RandomTreeNode root, RandomTreeNode cloneNode){
    if(root == null)
       return;

    if(cloneNode.left!=null){
      RandomTreeNode cloneLeft = cloneNode.left.left;
      root.left = root.left.left;
      cloneNode.left = cloneLeft;
    } else {
      root.left = null;
    }

    restoreOrignalTree(root.left,cloneNode.left);
    restoreOrignalTree(root.right, cloneNode.right);
  }

  public static void main(String args[]){

    RandomTreeNode tree = new RandomTreeNode(1);
    RandomTreeNode n2 =  new RandomTreeNode(6);
    RandomTreeNode n3 = new RandomTreeNode(12);
    RandomTreeNode n4 = new RandomTreeNode(5);
    RandomTreeNode n5 = new RandomTreeNode(8);
    RandomTreeNode n6 = new RandomTreeNode(11);
    RandomTreeNode n7 = new RandomTreeNode(13);
    RandomTreeNode n8 = new RandomTreeNode(7);
    RandomTreeNode n9 = new RandomTreeNode(9);
    tree.left = n2;
    tree.right = n3;
    tree.random = n2;
    n2.left = n4;
    n2.right = n5;
    n2.random = n8;
    n3.left = n6;
    n3.right = n7;
    n3.random = n5;
    n4.random = n9;
    n5.left = n8;
    n5.right = n9;
    n5.random = tree;
    n6.random = n9;
    n9.random = n8;

    CloneTreeWithRandomPointers obj = new CloneTreeWithRandomPointers();
    System.out.println("Orignal Tree Inorder Traversal..\n");
    obj.inorderTraversal(tree);
    System.out.println("\nClonning TREE");
    RandomTreeNode cloneTree =  obj.clone(tree);
    System.out.println("Cloned Tree Inorder Traversal..\n");
    obj.inorderTraversal(cloneTree);

  }

}



