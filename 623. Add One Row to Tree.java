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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        return helper (root, v, d, 1);
    }
    
    private TreeNode helper (TreeNode root, int v, int d, int level) {
        if (root == null)
            return null;
        if (level < d-1) {
            helper (root.left, v, d, level+1);
            helper (root.right, v, d, level+1);
        }
        else if (level == d-1) {
            TreeNode node1 = new TreeNode(v);
            TreeNode node2 = new TreeNode(v);
            node1.left = root.left;
            root.left = node1;
            node2.right = root.right;
            root.right = node2;
        }
        return root;
    }
}