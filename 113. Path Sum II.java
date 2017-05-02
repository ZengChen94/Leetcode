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
    public List<List<Integer>> pathSum(TreeNode root, int sum){
    	List<List<Integer>> result  = new LinkedList<List<Integer>>();
    	List<Integer> currentResult  = new LinkedList<Integer>();
    	hasPathSum(root, sum, currentResult, result);
    	return result;
    }
    
    public void hasPathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        if(root == null) return;
        currentResult.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0) {
            List<Integer> currentResultCopy  = new LinkedList<Integer>(currentResult);
            result.add(currentResultCopy);
            currentResult.remove(currentResult.size()-1);
            return;   
        }
        hasPathSum(root.left, sum - root.val, currentResult, result);
        hasPathSum(root.right, sum - root.val, currentResult, result);
        currentResult.remove(currentResult.size()-1);
        return;
    }
}

