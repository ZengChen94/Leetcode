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
    public int sumNumbers(TreeNode root) {
    	return helper(root, 0);
    }
    
    public int helper(TreeNode n, int sum){
    	if (n == null) return 0;
    	if (n.right == null && n.left == null) return sum*10 + n.val;
    	return helper(n.left, sum*10 + n.val) + helper(n.right, sum*10 + n.val);
    }
}