public class Solution {
    //memorized dfs
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();//here the map memorized
        return dfs(s, wordDict, map);
    }
    
    List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        LinkedList<String> result = new LinkedList<String>();     
        
        if (s.length() == 0) {
            result.add("");
            return result;
        }   
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, result);
        
        return result;
    }
}