/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists, 0, lists.length-1);
    }
    
    //merge a binary tree
    public static ListNode partion(ListNode[] lists, int start, int end){
        if(start == end)  return lists[start];
        if(start < end){
            int middle = (start + end) / 2;
            ListNode l1 = partion(lists, start, middle);
            ListNode l2 = partion(lists, middle+1, end);
            return merge(l1, l2);
        }
        else
            return null;
    }
    
    public static ListNode merge(ListNode l1, ListNode l2){
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