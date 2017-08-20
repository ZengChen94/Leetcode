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
    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root == null)
            return 0;
        int max = 0;
        root.val = 1;
        helper(root);
        list.add(root);
        while(list.size() != 0) {
            int size = list.size();
            int start = list.get(0).val;
            int end = list.get(list.size()-1).val;
            max = Math.max(max, end - start+1);
            for (int i = 0; i < size; i++) {
                TreeNode node = list.get(0);
                list.remove(0);
                if (node.left != null)
                    list.add(node.left);
                if (node.right != null) 
                    list.add(node.right);
            }
        }
        return max;
    }
    
    public void helper(TreeNode root) {
        if (root.left != null) {
            root.left.val = root.val * 2;
            helper(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 1;
            helper(root.right);
        }
    }
}