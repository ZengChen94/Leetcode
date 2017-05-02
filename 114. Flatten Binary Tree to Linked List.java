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
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        while (root != null){
            if (root.left == null)
                root = root.right;
            else {
                TreeNode run = root.left;
                while (run.right != null)
                    run = run.right;
                run.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
        root = dummy.right;
    }
}