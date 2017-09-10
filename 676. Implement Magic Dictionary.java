class MagicDictionary {
    public List<String> list = new LinkedList<String>();
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (int i = 0; i < dict.length; i++)
            list.add(dict[i]);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < list.size(); i++) {
            if (compareWord(list.get(i), word))
                return true;
        }
        return false;
    }
    
    public boolean compareWord(String target, String word) {
        int cnt = 0;
        char targetChar = '0';
        if (word.length() != target.length())
            return false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                cnt += 1;
                if (cnt == 2)
                    return false;
                targetChar = word.charAt(i);
            }
        }
        if (cnt == 0)
            return false;
        return true;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */