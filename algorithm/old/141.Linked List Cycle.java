/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        do {
            if(fast.next != null && fast.next.next != null) fast = fast.next.next;
            else return false;
            slow = slow.next;
        } while (slow != fast);
        
        return true;
    }
}   