/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = null, slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        
        return merge(head1, head2);
    }
    
    ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode run = head;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                run.next = head1;
                head1 = head1.next;
            } 
            else {
                run.next = head2;
                head2 = head2.next;
            }
            run = run.next;
        }
        
        if (head1 != null)
            run.next = head1;
        
        if (head2 != null)
            run.next = head2;
        
        return head.next;
    }
}