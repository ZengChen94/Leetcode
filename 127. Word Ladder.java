public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int cnt = 1;
        int level = 1;
        Set<String> set = new HashSet<String>();
        for (String s : wordList)
            set.add(s);
        
        while (cnt != 0) {
            int cntTmp = cnt;
            cnt = 0;
            while (cntTmp != 0){
                String str = queue.poll();
                cntTmp--;
                if (str != null) {
                    for (int i = 0; i < str.length(); i++) {
                        char[] chars = str.toCharArray(); 
                        for (char c = 'a'; c <= 'z'; c++) {
                            chars[i] = c;
                            String word = new String(chars);
                            if (set.contains(word) && word.equals(endWord)) return level + 1;
                            if (set.contains(word)) {
                                queue.add(word);
                                set.remove(word);
                                cnt++;
                            }
                        }
                    }
                } 
            }
            level++;
        }
        
        return 0;
    }
}