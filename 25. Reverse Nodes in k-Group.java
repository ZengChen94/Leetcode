/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode cur = new ListNode(0);
        ListNode pre = new ListNode(0);
        cur.next = head;
        pre.next = head;
        for (int i = 0; i < k; i++){
            cur = cur.next;
            if (cur == null)
                return head;
        }
        ListNode next = reverseKGroup(cur.next, k);
        ListNode end = head;
        while (head.next != cur){
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = end;
            end = tmp;
        }
        cur.next = end;
        head.next = next;
        return cur;
    }
}