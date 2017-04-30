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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> subTree = new ArrayList<>();
        if (n == 0) return subTree;
        return generate(1, n);
    }
    
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> subTree = new ArrayList<>();
        if (start > end) {
            subTree.add(null);
            return subTree;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> leftSubs = generate(start, k - 1);
            List<TreeNode> rightSubs = generate(k + 1, end);
            for (int i = 0; i < leftSubs.size(); i++) {
                for (int j = 0; j < rightSubs.size(); j++) {
                    TreeNode node = new TreeNode(k);
                    node.left = leftSubs.get(i);
                    node.right = rightSubs.get(j);
                    subTree.add(node);
                }
            }
        }
        return subTree;
    }
}