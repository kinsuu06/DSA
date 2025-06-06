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
    public ListNode deleteMiddle(ListNode head) {
        int cnt = 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            cnt++;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(cnt == 0) return head.next;
        int i=0;
        ListNode temp = head;
        while(temp != null){
            i++;
            if(i == cnt){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

  // optimised

  public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null) return null;
        fast = fast.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
