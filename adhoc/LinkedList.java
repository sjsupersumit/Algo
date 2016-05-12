import com.sun.istack.internal.NotNull;

/**
 * Created by sumit.jha on 4/16/16.
 */
public class LinkedList {

  Node a;

   static class Node{
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }


  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  void pushBack(Node head, int data){
    while(head!=null && head.next!=null) {
      head = head.next;
    }
    head.next = new Node(data);
  }

  Node pushFront(Node head, int data){
    if(head == null){
      head = new Node(data);
      return head;
    }

    Node begin = new Node(data);
    begin.next = head;
    return begin;

  }

  boolean isLoop(Node head){
    boolean res = false;
    Node loopNode = null;

    if(head == null || head.next == null)
      return  false;

    Node slow = head;
    Node fast = head.next;

    while(slow!=null  && fast!=null && slow!=fast){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        /*

        slow = head;
        while (slow != fast->next)
        {
            slow = slow->next;
            fast = fast->next;
        }

        // since fast->next is the looping point
        fast->next = NULL; // remove loop
         **/
        res = true;
        System.out.println("Found loop..removing it ");
        removeLoop(slow, head);
        break;
      }
    }

   return res;
  }

  void removeLoop(Node loop, Node head ){
    Node ptr1 = loop;
    Node ptr2 = loop;

    // Count the number of nodes in loop
    int k = 1, i;
    while (ptr1.next != ptr2) {
      ptr1 = ptr1.next;
      k++;
    }

    // Fix one pointer to head
    ptr1 = head;

    // And the other pointer to k nodes after head
    ptr2 = head;
    for (i = 0; i < k; i++) {
      ptr2 = ptr2.next;
    }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
    while (ptr2 != ptr1) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    // Get pointer to the last node
    ptr2 = ptr2.next;
    while (ptr2.next != ptr1) {
      ptr2 = ptr2.next;
    }

        /* Set the next node of the loop ending node
         to fix the loop */
    ptr2.next = null;

  }

  Node reverseList(Node head)
  {
    // Initialize prev and current pointers
    Node prev = null, curr = head, next;

    while (curr!=null)
    {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;
    return head;
  }


  public static void main(String args[]){
    LinkedList list = new LinkedList();
    list.a = new Node(1);
    list.a.next = new Node(2);
    list.a.next.next = new Node(3);

   list.a =   list.pushFront(list.a, 0);

//    for(int i=4;i<101;i++) {
//      list.pushBack(list.a, i);
//
//    }
//    Node b = new Node(4);
//    Node c = new Node(5);
//    list.a.next = b;
//    b.next = c;
//   //Creating loop in list
//    c.next = b;

//    System.out.println("Is Loop " + list.isLoop(list.a));
    list.printList(list.a);

//    System.out.println("Reversing the list");
//    list.a = list.reverseList(list.a);
//
//    list.printList(list.a);
  }
}
