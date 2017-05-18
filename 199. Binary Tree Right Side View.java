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
    int cnt = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode root, List<Integer> result, int depth){
        if(root == null){
            return;
        }
        if(cnt == depth){
            result.add(root.val);
            cnt++;
        }
        
        rightView(root.right, result, depth + 1);
        rightView(root.left, result, depth + 1);
    }
}