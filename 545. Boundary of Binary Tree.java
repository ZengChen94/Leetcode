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
      
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        
        GetLeftPath(root.left,list);//add left boundary node and leaves node
        GetRightPath(root.right, list);// add right boundary node and leaves node
      
        return list;
    }
    
    public void GetLeftPath(TreeNode left,List<Integer>list){
        if(left!=null){
            list.add(left.val);// add the left boundary node
            if(left.left!=null){
                GetLeftPath(left.left, list);
                DFS(left.right,list);
            }
            else{// according to the rule, if the node has no left subtree,then the left path goes to right
                GetLeftPath(left.right, list);
            }
        }
    }
    
    public void GetRightPath(TreeNode right,List<Integer>list){
        if(right!=null){
            if(right.right!=null){
                DFS(right.left,list);
                GetRightPath(right.right, list);
            }
            else{
                //according to the rule,if the node has no right subtree,then the right path goes to left
                GetRightPath(right.left, list);
            }
            list.add(right.val);
        }
    }
    
 
    public void DFS(TreeNode node,List<Integer>list){
        if(node!=null){
            if(node.left==null&&node.right==null){
                list.add(node.val);
            }
            else{
                DFS(node.left, list);
                DFS(node.right,list);
            }
        }
    }
}