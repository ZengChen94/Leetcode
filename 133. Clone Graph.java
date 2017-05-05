/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();//using node.value to track node
        map.put(node, newNode);
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.pop();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        
        return newNode;
    }
}