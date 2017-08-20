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
    int sum;
    boolean res;
    
    public boolean checkEqualTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return false;
        helper(root);
        helper2(root);
        return res;
    }
    
    public void helper(TreeNode root) {
        if (root == null)
            return;
        sum += root.val;
        helper(root.left);
        helper(root.right);
    }
    
    public int helper2(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper2(root.left);
        int right = helper2(root.right);
        int total = left + right + root.val;
        if (total * 2 == sum) {
            res = true;
        }
        return total;
    }
}