/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
		
		ListNode run = head.next;
		ListNode tail = head;
		
		while (run != null) {
		    ListNode cur = run;
		    run = run.next;
		    if (cur.val <= head.val) {
		        tail.next = run;
		        cur.next = head;
		        head = cur;
		    }
		    else if (cur.val >= tail.val) {
		        tail = cur;
		        continue;
		    }
		    else {
		        ListNode run2 = head;
		        while (run2 != tail) {
		            if (run2.val < cur.val && cur.val < run2.next.val || run2.val == cur.val) {
		                tail.next = run;
		                cur.next = run2.next;
		                run2.next = cur;
		                break;
		            }
		            run2 = run2.next;
		        }
		    }
		}
		
		return head;
    }
}