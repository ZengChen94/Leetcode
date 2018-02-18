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
    Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null)
            ans = Math.min(ans, node.val - prev);
        prev = node.val;
        dfs(node.right);
    }
}