/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */  
public class Codec {  
  
    // Encodes a tree to a single string.  
    public String serialize(TreeNode root) {  
        StringBuilder sb = new StringBuilder();  
          
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.offer(root);  
          
        while (!queue.isEmpty()) {  
            TreeNode node = queue.poll();  
            if (node == null) {  
                sb.append("null,");  
            } 
			else {  
                sb.append(String.valueOf(node.val) + ",");  
                queue.offer(node.left);  
                queue.offer(node.right);  
            }  
        }  
          
        return sb.toString();  
    }  
  
    // Decodes your encoded data to tree.  
    public TreeNode deserialize(String data) {  
        if (data.isEmpty()) return null;  
          
        String[] vals = data.split(",");  
        int[] nums = new int[vals.length]; // 节点i及之前null节点的个数  
        TreeNode[] nodes = new TreeNode[vals.length];  
          
        for (int i = 0; i < vals.length; i++) {  
            if (i > 0) {  
                nums[i] = nums[i - 1];  
            }  
            if (vals[i].equals("null")) {  
                nodes[i] = null;  
                nums[i]++;  
            } else {  
                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));  
            }  
        }  
          
        for (int i = 0; i < vals.length; i++) {  
            if (nodes[i] == null) {  
                continue;  
            }  
            nodes[i].left = nodes[2 * (i - nums[i]) + 1];  // important!!! // start from 0
            nodes[i].right = nodes[2 * (i - nums[i]) + 2];  
        }  
          
        return nodes[0];  
    }  
}  
  
// Your Codec object will be instantiated and called as such:  
// Codec codec = new Codec();  
// codec.deserialize(codec.serialize(root)); 