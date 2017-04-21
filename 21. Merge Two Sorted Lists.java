/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            pre.next = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }
        else {
            pre.next = l2;
            l2.next = mergeTwoLists(l2.next, l1);
        }
        return pre.next;
        
    }
}