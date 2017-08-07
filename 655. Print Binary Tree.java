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
    public List<List<String>> printTree(TreeNode root) {
        int depth = helper(root);
        int m = depth;
        int n = 1;
        for (int i = 0; i < depth; i++) {
            n = n * 2;
        }
        n = n - 1;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.MIN_VALUE;
        helper2(root, map, 0, 0, n-1);
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (map[i][j] != Integer.MIN_VALUE)
                    tmp.add(map[i][j]+"");
                else
                    tmp.add("");
            }
            result.add(tmp);
        }
        return result;
    }
    
    public int helper(TreeNode root) {
        if (root == null) 
            return 0;
        else 
            return Math.max(helper(root.left)+1, helper(root.right)+1);
    }
    
    public int[][] helper2(TreeNode root, int[][] map, int m, int left_n, int right_n) {
        if (m == map.length || root == null)
            return map;
        map[m][(left_n+right_n)/2] = root.val;
        helper2(root.left, map, m+1, left_n, (left_n+right_n)/2-1);
        helper2(root.right, map, m+1, (left_n+right_n)/2+1, right_n);
        return map;
    }
}