// Class Node
public class Node<T> {

   int value;
   Node next, prev;
   
   // Constructor
   public Node() {
      next = null;  // Make sure two links are together
      prev = null;
      value = 0;
   }
   
   // Constructor
   public Node(T d, Node n, Node p) {
      value = d;
      next = n;
      prev = p;
   }
   
   // Function to set link to next node
   public void setLinkNext(Node n) {
      next = n;
   }
   
   // Function to set link to previous node
   public void setLinkPrev(Node p) {
      prev = p;
   }
   
   // Function to get link to next node
   public Node getLinkNext() {
      return next;
   }
   
   // Function to get link to previous node
   public Node getLinkPrev() {
      return prev;
   }
   
   // Function to set value to node
   public void setValue(T d) {
      value = d;
   }
   
   // Function to get value from node
   public int getValue() {
      return value;
   }
} // End Class Node
