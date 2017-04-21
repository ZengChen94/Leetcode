/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode result = new ListNode(0);
        result.next = head.next;//important!!!
        
        ListNode prev = new ListNode(0);
        ListNode cur = new ListNode(0);
        prev.next = head;
        cur = head;
        
        while (cur != null && cur.next != null){
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = prev.next;
        }
        return result.next;
    }
}