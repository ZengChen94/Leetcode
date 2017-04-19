/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int value = l1.val + l2.val + carry;
                carry = value / 10;
                value = value % 10;
                ListNode node = new ListNode(value);
                current.next = node;
                current = current.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 == null && l2 != null) {
                while (carry != 0 && l2 != null) {
                    int value = l2.val + carry;
                    carry = value / 10;
                    value = value % 10;
                    ListNode node = new ListNode(value);
                    current.next = node;
                    current = current.next;
                    l2 = l2.next;
                }
                if (l2 != null) {
                    current.next = l2;
                    return head.next;
                }
                else {
                    if (carry == 0)
                        return head.next;
                    else {
                        ListNode node = new ListNode(carry);
                        current.next = node;
                        current = current.next;
                        return head.next;
                    }
                }
            }
            else if (l1 != null && l2 == null) {
                while (carry != 0 && l1 != null) {
                    int value = l1.val + carry;
                    carry = value / 10;
                    value = value % 10;
                    ListNode node = new ListNode(value);
                    current.next = node;
                    current = current.next;
                    l1 = l1.next;
                }
                if (l1 != null) {
                    current.next = l1;
                    return head.next;
                }
                else {
                    if (carry == 0)
                        return head.next;
                    else {
                        ListNode node = new ListNode(carry);
                        current.next = node;
                        current = current.next;
                        return head.next;
                    }
                }
            }
        }
        if (carry != 0){
            ListNode node = new ListNode(carry);
            current.next = node;
            current = current.next;
        }
        return head.next;
    }
}