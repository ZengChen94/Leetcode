public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        
        Trie root = new Trie();
        
        for (String dictWord : dict) {
            root.insert(dictWord);
        }
        
        String[] words = sentence.split(" ");
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (int i = 1; i <= word.length(); i++) {
                if (root.search(word.substring(0, i))) {
                    words[j] = word.substring(0, i);
                    break;
                }
            }
        }
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0)
                result += words[i];
            else {
                result += " ";
                result += words[i];
            }
        }
        return result;
    }
}

class TrieNode {
    public char val;
    public boolean isWord; //important
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

class Trie {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i)-'a'] == null) {
                TrieNode tmp = new TrieNode(word.charAt(i));
                cur.children[word.charAt(i)-'a'] = tmp;
            }
            cur = cur.children[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i)-'a'] == null)
                return false;
            else
                cur = cur.children[word.charAt(i)-'a'];
        }
        if (cur.isWord == true)
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i)-'a'] == null)
                return false;
            else
                cur = cur.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}