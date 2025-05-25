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
  public static void main(String[] args){
    int[] arr = {2, 4, 6, 7};
    Node y = new Node(arr[2]);
    System.out.println(y.data);
  }
}
