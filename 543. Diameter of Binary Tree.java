/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int cnt = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return cnt-1;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int left = helper(root.left);
            int right = helper(root.right);
            cnt = Math.max(cnt, left+right+1);
            return Math.max(left, right) + 1;
        }
    }
}