
class Node{
  int data;
  Node next;

  Node(int data, Node next1){
    this.data = data;
    this.next = next1;
  }
  
  Node(int data){
    this.data = data;
    this.next = null;
  }
}

public class Main{
  private static Node convertArr2LL(int[] arr){
    Node head = new Node(arr[0]);
    Node mover = head;
    for(int i=1; i<arr.length; i++){
      Node temp = new Node(arr[i]);
      mover.next = temp;
      mover = temp;
    }
    return head;
  }
  public static int length(Node head){
    int count = 0;
    Node temp = head;
    while(temp != null){
      count++;
      temp = temp.next;
    }
    return count;
  }
  
  public static void main(String[] args){
    int[] arr = {2, 4, 6, 7};
    Node head = convertArr2LL(arr);
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
    System.out.println(length(head));
  }
}
