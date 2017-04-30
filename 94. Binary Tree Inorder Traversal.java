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
    //Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}

public class Solution {
    //Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        if (root == null) return result1;
        if (root.left != null) result1 = inorderTraversal(root.left);
        if (root.right != null) result2 = inorderTraversal(root.right);
        result1.add(root.val);
        result1.addAll(result2);
        return result1;
    }
}

public class Solution {
    // Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
		while(root != null){
			if (root.left == null) {
			    result.add(root.val);
			    root = root.right;
			}
			else {
			    TreeNode pre = root.left;
			    while (pre.right != null && pre.right != root)
			        pre = pre.right;
			    if (pre.right == null) {
			        pre.right = root;
			        root = root.left;
			    }
			    else if (pre.right == root) {
			        result.add(root.val);
			        pre.right = null;
			        root = root.right;
			    }
			}
		}
    
        return result;
    }
}