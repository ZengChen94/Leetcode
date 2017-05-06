/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){ 
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //slow is the end of first half
        ListNode secondHead = slow.next;
        while (secondHead.next != null) {
            ListNode secondHeadNext = secondHead.next;
            secondHead.next = secondHeadNext.next;
            secondHeadNext.next = slow.next;
            slow.next = secondHeadNext;
        }
        
        secondHead = slow.next;
        slow.next = null;
        ListNode firstHead = head;
        while (secondHead != null){
            ListNode secondHeadTmp = secondHead.next;
            secondHead.next = firstHead.next;
            firstHead.next = secondHead;
            firstHead = firstHead.next.next;
            secondHead = secondHeadTmp;
        }
    }
}