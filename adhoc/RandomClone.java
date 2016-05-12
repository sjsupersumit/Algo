/**
 * Created by sumit.jha on 5/7/16.
 */

/*
* Given a LinkedList with random pointer, Clone it
* */
public class RandomClone {

    class LLNode{

      int data;
      LLNode next;
      LLNode random;

      public LLNode(int data) {
        this.data = data;
        next = random = null;
      }

    }

  //Returns new  copy of the list
  public LLNode copyRandomLinkedList(LLNode head){

    if(head  == null){
      return null;
    }

    LLNode curr = head;
    //copy every node and insert it into list just after the original node
    while(curr!=null){
      LLNode copy = new LLNode(curr.data);
      copy.next = curr.next;
      curr.next = copy;
      curr = copy.next;
    }

    //Now copy the random pointer of each new node
    curr = head;
    while(curr!=null){
      if(curr.random!=null){
        curr.next.random = curr.random.next;
        curr = curr.next.next;
      }
    }

    //Now seperate the list i.e. break it in to two and return the cloned list
    curr = head;
    LLNode copyHead = head.next;
    while (curr!=null ){
      LLNode temp = curr.next;
      curr.next = temp.next;
      if(temp.next!=null){
        temp.next = temp.next.next;
      }
      curr = curr.next;
    }

    return copyHead;
  }

}
