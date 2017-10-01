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
    int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) 
            dfs(root);//search one pass longest
        return max;
    }

    private int dfs(TreeNode node) {
        int left = node.left != null ? dfs(node.left) : 0;
        int right = node.right != null ? dfs(node.right) : 0;
        int resleft = node.left != null && node.left.val == node.val ? left + 1 : 0;
        int resright = node.right != null && node.right.val == node.val ? right + 1 : 0;
        max = Math.max(max, resleft + resright);
        return Math.max(resleft, resright);
    }
}