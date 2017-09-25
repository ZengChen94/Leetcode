

class MapSum {
    Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node(0);
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            if (cur.map[key.charAt(i)-'a'] == null) {
                cur.map[key.charAt(i)-'a'] = new Node(0);
            }
            cur = cur.map[key.charAt(i)-'a'];
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        int cnt = 0;
        int i = 0;
        for (; i < prefix.length(); i++) {
            if (cur.map[prefix.charAt(i)-'a'] == null)
                return 0;
            else
                cur = cur.map[prefix.charAt(i)-'a'];
        } 
        cnt = helper(cur, cnt);
        return cnt;
    }
    
    int helper(Node cur, int cnt) {
        if (cur.val != 0)
            cnt += cur.val;
        for (int j = 0; j < 26; j++) {
            if (cur.map[j] != null) 
                cnt = helper(cur.map[j], cnt);
        }
        return cnt;
    }
}

class Node {
    int val;
    Node[] map = new Node[26];
    Node(int val) {
        this.val = val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */