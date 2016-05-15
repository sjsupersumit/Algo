

/**
 * Created by sumit.jha on 5/4/16.
 */

/* Finds the max difference between 2 node A,B in tree such that A is ancestor of B
*
*   2
 10   3
4 5 6 0
*
* should return
* */



class Result{
  int res;

  public Result(int res) {
    this.res = res;
  }

}


public class TreeDiff {


 static Integer getDiff(TreeNode root){
    if(root == null){
      return null;
    }

    Result result = new Result(Integer.MIN_VALUE);
    getDiffUtil(root, result);
    System.out.println(result.res);
    return result.res;
  }

  static Integer getDiffUtil(TreeNode root, Result r){

    if(root.left == null && root.right == null){
      return root.data;
    }

    Integer l  = getDiffUtil(root.left, r);

    if(root.data - l  > r.res){
      r.res = root.data- l;
    }

    Integer ri  = getDiffUtil(root.right,r);
    if(root.data - ri  > r.res  ){
      r.res = root.data- ri;
    }

    return Math.min(l,ri);

  }






  public static void main(String[] args){

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(10);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left =  new TreeNode(6);
    root.right.right =  new TreeNode(0);

    getDiff(root);


  }
}
