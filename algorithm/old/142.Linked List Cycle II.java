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
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0); // dummy head
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        do {
            if (fast.next != null && fast.next.next != null) fast = fast.next.next;
            else return null;
            slow = slow.next;
        } while (slow != fast);
        
        fast = dummy;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}