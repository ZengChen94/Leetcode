public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //Arrays.sort(strs);
        
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sCopy = String.valueOf(charArray);
            
            if (!map.containsKey(sCopy)) 
                map.put(sCopy, new ArrayList<String>());
            map.get(sCopy).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}