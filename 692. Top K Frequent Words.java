public class Solution {
    public class Pairs{
        int freq;
        String word;
        public Pairs (int freq, String word) {
            this.freq = freq;
            this.word = word;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word)+1);
        }
        Pairs[] pairsList = new Pairs[map.size()];
        int i = 0;
        for (String key : map.keySet()) {
            pairsList[i] = new Pairs(map.get(key), key);
            i++;
        }
        Arrays.sort(pairsList, (a, b)->(a.freq == b.freq? a.word.compareTo(b.word) : b.freq-a.freq));
        LinkedList<String> result = new LinkedList<String>();
        i = 0;
        while (k != 0) {
            k--;
            result.add(pairsList[i].word);
            i++;
        }
        return result;
    }
}