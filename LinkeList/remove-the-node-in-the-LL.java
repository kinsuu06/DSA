
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

  public static Node removeHead(Node head){
    head = head.next;
    return head;
  }
  
  public static Node removeTail(Node head){
      if(head == null || head.next == null) return null;
    Node temp = head;
    while(temp.next.next != null){
      temp = temp.next;
    }
    temp.next = null;
    return head;
  }

  public static Node KthNode(Node head, int k){
      if(head == null) return null;
    if(k == 1) return removeHead(head);
    Node temp = head;
    Node prev = null;
    int cnt = 0;
    while(temp.next != null){
      cnt++;
      if(cnt == k){
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return head;
  }
  
  public static Node valueNode(Node head, int val){
      if(val == head.data) return removeHead(head);
      Node temp = head;
      Node prev = null;
      while(temp.next != null){
          if(temp.data == val){
              prev.next = prev.next.next;
              break;
          }
          prev = temp;
          temp = temp.next;
      }
      return head;
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
    // Node rmvhead = removeHead(head);
    // Node temp1 = rmvhead;
    // while(temp1 != null){
    //   System.out.print(temp1.data + " ");
    //   temp1 = temp1.next;
    // }
    
    // Node rmvhead = removeTail(head);
    // Node temp1 = rmvhead;
    // while(temp1 != null){
    //   System.out.print(temp1.data + " ");
    //   temp1 = temp1.next;
    // }
    
    Node rmvhead = KthNode(head, 4);
    Node temp1 = rmvhead;
    while(temp1 != null){
      System.out.print(temp1.data + " ");
      temp1 = temp1.next;
    }
    
    // Node rmvhead = valueNode(head, 4);
    // Node temp1 = rmvhead;
    // while(temp1 != null){
    //   System.out.print(temp1.data + " ");
    //   temp1 = temp1.next;
    // }
    
  }
}
