public class Solution {
    public int hIndex(int[] citations) {
        //binary search
        int low = 0, high = citations.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (citations.length-mid == citations[mid]) {
                return citations.length-mid;
            }
            else if (citations.length-mid > citations[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return citations.length-low;
    }
}