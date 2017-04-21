/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer1 = new ListNode(0);
        ListNode pointer2 = new ListNode(0);
        pointer1.next = head;
        pointer2.next = head;
        for (int i = 0; i < n; i++)
            pointer1 = pointer1.next;
        if (pointer1.next == null)
            return head.next;
        while (pointer1.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer2.next.next;
        return head;
    }
}