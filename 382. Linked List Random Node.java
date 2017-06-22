/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode head;
    Random random;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;       
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode tmp = head;
        int value = tmp.val;
        for(int i = 1; tmp.next != null; i++){
            tmp = tmp.next;
            if(random.nextInt(i + 1) == i)
                value = tmp.val;                        
        }
        return value;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */