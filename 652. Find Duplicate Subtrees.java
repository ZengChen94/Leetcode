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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        helper(root, map, result);
        return result;
    }
    
    String helper(TreeNode root, HashMap<String, Integer> map, LinkedList<TreeNode> result) {
        if (root == null)
            return new String("#");
        else {
            String tmp1 = helper(root.left, map, result);
            String tmp2 = helper(root.right, map, result);
            String tmp = tmp1 + tmp2 + root.val;
            if (map.containsKey(tmp)) {
                if (map.get(tmp) == 1)
                    result.add(root);
                map.put(tmp, map.get(tmp)+1);
            }
            else
                map.put(tmp, 1);
            return tmp;
        }
    }
}