//581. Shortest Unsorted Continuous Subarray
//Time: O(nlgn)
//Space: O(n)
//Java

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) 
            nums2[i] = nums[i];
        Arrays.sort(nums2);
        int cnt1 = -1;
        int cnt2 = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums2[i]) 
                cnt1 = i;
            else
                break;
        }
        if (cnt1 == nums.length-1)
            return 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == nums2[i])
                cnt2 = i;
            else
                break;
        }
        cnt1 = cnt1 + 1;
        cnt2 = (nums.length-1) - cnt2 + 1;
        return nums.length - cnt1 - cnt2;
    }
}

//581. Shortest Unsorted Continuous Subarray
//Time: O(n)
//Space: O(1)
//Java

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int low = nums.length-1, high = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) high = i;
            max = nums[i] > max? nums[i] : max;
        }
        
        if (high == 0) return 0;
        
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > min) low = i;
            min = nums[i] < min? nums[i] : min;
        }
        
        return high - low + 1;
    }
}
