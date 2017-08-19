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
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (!(l1 == null && l2 == null)) {
            ListNode tmp = new ListNode(0);
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            tmp.val = (a + b + carry)%10;
            carry = (a + b + carry)/10;
            cur.next = tmp;
            cur = cur.next;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            cur.next = tmp;
            cur = cur.next;
        }
        return pre.next;
    }
}