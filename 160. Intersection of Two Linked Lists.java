/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
    
        while(a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
}

//method2: connect headA with headA.end. And then set slow and fast to travel it