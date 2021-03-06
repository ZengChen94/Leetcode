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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    
    public boolean helper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;
        else if (set.contains(k-root.val))
            return true;
        else {
            set.add(root.val);
            return helper(root.left, k, set) || helper(root.right, k, set);
        }
    }
    
}