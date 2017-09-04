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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }
    
    TreeNode helper(TreeNode root, int L, int R) {
        while (root != null && (root.val < L || root.val > R)) {
            if (root.val < L)
                root = root.right;
            else if (root.val > R)
                root = root.left;
        }
        if (root == null)
            return null;
        root.left = helper(root.left, L, R);
        root.right = helper(root.right, L, R);
        return root;
    }
}