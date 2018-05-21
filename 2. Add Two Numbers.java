/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null? 0 : l1.val;
            int val2 = l2 == null? 0 : l2.val;
            ListNode cur = new ListNode((val1+val2+carry)%10);
            pre.next = cur;
            pre = cur;
            carry = (val1+val2+carry)/10;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
        }
        if (carry == 1) {
            ListNode cur = new ListNode(1);
            pre.next = cur;
        }
        return dummy.next;
    }
}