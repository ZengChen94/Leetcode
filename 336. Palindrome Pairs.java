public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new LinkedList<>();
        if (words == null) 
            return pairs;
        HashMap<String, Integer> map = new HashMap<>();
		//word, index
        for (int i = 0; i < words.length; ++ i) 
            map.put(words[i], i);
        for (int i = 0; i < words.length; ++ i) {
            int l = 0, r = 0;
            while (l <= r) {
                String s = words[i].substring(l, r);
				//search whether the reverse of the cut off part can be found in the map
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
                    pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                //take the front part
				if (r < words[i].length()) 
					r++;
				//take the back part
                else 
					l++;
            }
        }
        return pairs;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}