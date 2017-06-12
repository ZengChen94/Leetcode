public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    	for (int num : nums) {
    	    if (map.containsKey(num))
    	        map.put(num, map.get(num)+1);
    	    else
    	        map.put(num, 1);
    	}
    
    	for (int key : map.keySet()) {
    		int frequency = map.get(key);
    		if (bucket[frequency] == null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		bucket[frequency].add(key);
    	}
    	
    	List<Integer> result = new ArrayList<>();
    
    	for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
    		if (bucket[pos] != null) {
    			result.addAll(bucket[pos]);
    		}
    	}
    	
    	return result;
    }
}