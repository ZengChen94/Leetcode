/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(head.val-1);
        pre.next = head;
        ListNode run = pre;
        ListNode run2 = pre;
        while (run.next.next != null) {
            if (run.val != run.next.val && run.next.val != run.next.next.val){
                run2.next = run.next;
                run2 = run2.next;
            }
            run = run.next;
        }
        if (run.val != run.next.val){
            run2.next = run.next;
            run2 = run2.next;
        }
        run2.next = null;//rememver to set this
        return pre.next;
    }
}