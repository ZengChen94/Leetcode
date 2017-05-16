public class Solution {
    public int[] twoSum(int[] num, int target) {
        int[] result = new int[2];
        if (num == null || num.length < 2) return result;
        int left = 0, right = num.length - 1;
        
        while (left < right) {
            int sum = num[left] + num[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } 
            else if (sum > target)
                right --;
            else 
                left ++;
        }
        return result;
    }
}