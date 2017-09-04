/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        int left = helper(root.val, root.left);
        int right = helper(root.val, root.right);
        if (left > root.val && right > root.val && left != Integer.MAX_VALUE && right != Integer.MAX_VALUE)
            return Math.min(left, right);
        else if (left > root.val && left != Integer.MAX_VALUE)
            return left;
        else if (right > root.val && right != Integer.MAX_VALUE)
            return right;
        else 
            return -1;
    }
    
    public int helper(int min, TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.val == min)
            return Math.min(helper(min, root.left), helper(min, root.right));
        else    
            return root.val;
    }
}