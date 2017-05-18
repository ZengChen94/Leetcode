/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode run = dummy;
        while (run.next != null) {
            if (run.next.val == val){
                run.next = run.next.next;
                continue;
            }
            run = run.next;
            if (run == null)
                break;
        }
        return dummy.next;
    }
}