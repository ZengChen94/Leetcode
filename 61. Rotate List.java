/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        ListNode preHead = new ListNode(0);
        ListNode run = head;
        int cnt = 1;
        while (run.next != null) {
            cnt += 1;
            run = run.next;
        }
        k = k % cnt;
        
        if (k == 0) return head;
        
        ListNode quick = head;
        ListNode slow = head;
        while (k != 0){
            quick = quick.next;
            k--;
        }
        while (quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        run.next = head;
        preHead.next = slow.next;
        slow.next = null;
        return preHead.next;
    }
}