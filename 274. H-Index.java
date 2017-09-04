class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i] >= citations.length-1-i+1)
                result = citations.length-1-i+1;
            else
                break;
        }
        return result;
    }
}