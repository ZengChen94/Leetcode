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

// My solution
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
        String result = "";
        return helper(root, result);
    }  
    
    public String helper(TreeNode root, String result) {
        if (root == null) {
            result += "#,";
            return result;
        }
        result += (root.val+",");
        result = helper(root.left, result);
        result = helper(root.right, result);
        return result;
    }
  
    int cnt;
    
    // Decodes your encoded data to tree.  
    public TreeNode deserialize(String data) {  
        String[] vals = data.split(",");
        if (vals.length == 0)
            return null;
        cnt = 0;
        return helper2(vals);
    }  
    
    public TreeNode helper2(String[] vals) {
        if (cnt >= vals.length || vals[cnt].equals("#")) {
            cnt += 1;
            return null;
        }
        TreeNode root = new TreeNode(0);
        root.val = Integer.parseInt(vals[cnt]);
        cnt += 1;
        root.left = helper2(vals);
        root.right = helper2(vals);
        return root;
    }
}  
  
// Your Codec object will be instantiated and called as such:  
// Codec codec = new Codec();  
// codec.deserialize(codec.serialize(root)); 