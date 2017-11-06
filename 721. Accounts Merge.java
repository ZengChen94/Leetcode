class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        // This is similar to COPY GRAPH
        Map<String, Node> map = new HashMap<>();    // <Email, email node>  
                
        // Build the graph;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                
                if (!map.containsKey(email)) {
                    Node node = new Node(email, list.get(0));
                    map.put(email, node);
                }
                
                if (j == 1) continue;
                //Connect the current email node to the previous email node;
                map.get(list.get(j - 1)).neighbors.add(map.get(email));
                map.get(email).neighbors.add(map.get(list.get(j - 1)));
            }
        }
        
        // DFS search for each components(each account);
        Set<String> visited = new HashSet<>();
        for (String s : map.keySet()) {
            if (visited.add(s)) {
                List<String> list = new LinkedList<>();
                list.add(s);
                
                dfs(map.get(s), visited, list);
                
                Collections.sort(list);
                list.add(0, map.get(s).username);
                res.add(list);
            }
        }
        
        return res;
    }
    
    public void dfs(Node root, Set<String> visited, List<String> list) {
        for (Node node : root.neighbors) {
            if (visited.add(node.val)) {
                list.add(node.val);
                dfs(node, visited, list);
            }
        }
    }
    
    class Node {
        String val;         // Email address;
        String username;    // Username;
        List<Node> neighbors;
        Node(String val, String username) {
            this.val = val;
            this.username = username;
            neighbors = new ArrayList<>();
        }
    }
}