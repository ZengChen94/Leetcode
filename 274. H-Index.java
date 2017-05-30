public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        
        for (int i = citations.length; i >= 1; i--) {
            if (i <= citations[citations.length-i]) {
                result = i;
                break;
            }
        }
        return result;
    }
}