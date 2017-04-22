//method1: brute force
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        else if (needle.length() == 0)
            return 0;
        
        int threshold = haystack.length() - needle.length();
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

//method2: kmp
public class Solution {
    public int strStr(String haystack, String needle) {
    	if(needle.equals("")) return 0;
    	if(haystack.equals("")) return -1;
    	
    	int[] next = makeNext(needle);
        
        int i = 0, j = 0;
    	while (i != haystack.length()){
    	    while (j != -1 && haystack.charAt(i) != needle.charAt(j)) j = next[j];//next[j] means ..., j-2, j-1
    	    i++;
    	    j++;
    	    if (j == needle.length())
    	        return i - needle.length();
    	}
        return -1;
    }
    
    private int[] makeNext(String needle){
    	int[] next = new int[needle.length()+1];
        int i = 0, j = -1;
    	next[0] = -1;
    	
    	while(i != needle.length()){
    	    while (j != -1 && needle.charAt(i) != needle.charAt(j)) j = next[j];
    	    i++;
    	    j++;
    	    next[i] = j;
    	}
    
    	return next;
    }
}