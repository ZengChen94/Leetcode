public class Solution {
    public int maxProduct(String[] words) {
        if (words.length == 0)
    		return 0;
    	int[] value = new int[words.length];
    	
    	for (int i = 0; i < words.length; i++) {
    		String tmp = words[i];
    		value[i] = 0;
    		for (int j = 0; j < tmp.length(); j++) {
    			value[i] = value[i] | 1 << (tmp.charAt(j) - 'a');
    		}
    	}
    	
    	int max = 0;
    	for (int i = 0; i < words.length; i++)
    		for (int j = i + 1; j < words.length; j++) {
    			if ((value[i] & value[j]) == 0)
    				max = Math.max(max, words[i].length() * words[j].length());
    		}
    		
    	return max;
    }
}