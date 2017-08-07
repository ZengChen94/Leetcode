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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int low, int high) {
        if (low == high)
            return new TreeNode(nums[low]);
        if (low > high)
            return null;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, low, index-1);
        root.right = helper(nums, index+1, high);
        return root;
    }
}