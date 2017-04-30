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
    // Morris Traversal
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode preNode = null;
		while(root != null){
			if (root.left == null) {
			    if (preNode != null && root.val < preNode.val) {
			        if (first == null)
			            first = preNode;
			        second = root;
			    }
			    preNode = root;
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
			        if (preNode != null && root.val < preNode.val) {
			            if (first == null)
    			            first = preNode;
    			        second = root;
    			    }
    			    preNode = root; 
			        pre.right = null;
			        root = root.right;
			    }
			}
		}
		if(first!= null && second != null){
		    int t = first.val;
		    first.val = second.val;
		    second.val = t;
		}
    }
}