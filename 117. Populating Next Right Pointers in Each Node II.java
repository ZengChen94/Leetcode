/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null){
            TreeLinkNode cur = level_start;
            TreeLinkNode pre = level_start;
            int flag = 0;
            level_start = null;
            while(cur != null){
                if (cur.left != null || cur.right != null) {
                    if (flag == 0) {
                        flag = 1;
                        if (cur.left != null && cur.right != null) {
                            pre = cur.right;
                            level_start = cur.left;
                            cur.left.next = cur.right;
                        }
                        else if (cur.left != null && cur.right == null) {
                            pre = cur.left;
                            level_start = cur.left;
                        }
                        else {
                            pre = cur.right;
                            level_start = cur.right;
                        }
                    }
                    else {
                        if (cur.left != null && cur.right != null) {
                            pre.next = cur.left;
                            pre = cur.right;
                            cur.left.next = cur.right;
                        }
                        else if (cur.left != null && cur.right == null) {
                            pre.next = cur.left;
                            pre = cur.left;
                        }
                        else {
                            pre.next = cur.right;
                            pre = cur.right;
                        }
                    }
                }
                cur = cur.next;
            }
        }
    }
}