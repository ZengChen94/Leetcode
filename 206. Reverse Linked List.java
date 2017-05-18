/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = newHead;
            newHead = next;
        }
        return newHead;
    }
}