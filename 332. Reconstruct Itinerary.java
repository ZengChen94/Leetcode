public class Solution {
    LinkedList<String> result;
    Map<String, PriorityQueue<String>> map;
    
    public List<String> findItinerary(String[][] tickets) {
        result = new LinkedList<String>();
        map = new HashMap<String, PriorityQueue<String>>();
        if (tickets.length == 0) 
            return result;
        
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("JFK");
        return result;
    }
    
    public void dfs(String cur) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map.get(cur).poll());
        }
        result.add(0, cur);
    }
}