/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != st.peek()){
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return true;
    }

  // optimised

  public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newhead;
        while(second != null){
            if(first.val != second.val){
                reverse(newhead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newhead);
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode front = head;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
