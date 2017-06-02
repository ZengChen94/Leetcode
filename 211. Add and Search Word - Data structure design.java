public class WordDictionary {
    
    private class WordNode{
    	boolean isLeaf;
    	WordNode[] children = new WordNode[26];
    }
    WordNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new WordNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        WordNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i]-'a';
            if (cur.children[index] == null) {
                WordNode newNode = new WordNode();
                cur.children[index] = newNode;
            }
            cur = cur.children[index];  
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(chars, 0, root);
    }
    
    public boolean search(char[] chars, int index, WordNode parent){
    	if (index == chars.length){
    		if (parent.isLeaf)
    			return true;
    		else
    		    return false;
    	}
    	if (chars[index] == '.'){
	    	for (int i = 0; i < 26; i++){
	    		if (parent.children[i] != null){
	    			if (search(chars, index+1, parent.children[i]))
	    				return true;
	    		}
	    	}
	    	return false;
    	}
    	WordNode node = parent.children[chars[index]-'a'];
    	if (node == null)
    		return false;
    	return search(chars, index+1, node);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */