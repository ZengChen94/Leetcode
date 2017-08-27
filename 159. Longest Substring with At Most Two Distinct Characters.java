public int lengthOfLongestSubstringTwoDistinct(String s) {  
    int start = 0;  
    int maxLen = 0;  
  
    // Key: letter; 
	// Value: the index of the last occurrence.  
    Map<Character, Integer> map = new HashMap<Character, Integer>();  
    int i;  
    for (i = 0; i < s.length(); ++i) {  
        char c = s.charAt(i);  
        if (map.size() == 2 && !map.containsKey(c)) {  
            // Pick the character with the leftmost last occurrence.  
            char charEndsMostLeft = ' ';  
            int minLast = s.length();  
            for (char ch : map.keySet()) {  
                int last = map.get(ch);  
                if (last < minLast) {  
                    minLast = last;  
                    charEndsMostLeft = ch;  
                }  
            }  
  
            map.remove(charEndsMostLeft);  
            start = minLast + 1;  
        }  
        map.put(c, i);  
        maxLen = Math.max(maxLen, i - start + 1);  
    }  
    return maxLen;  
}  