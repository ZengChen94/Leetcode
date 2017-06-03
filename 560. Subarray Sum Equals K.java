// 560. Subarray Sum Equals K
// Time: O(n^2)
// Space: O(n)
// Java

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] nums2 = new int[nums.length];
        nums2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums2[i] = nums2[i-1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums2[j] - nums2[i] + nums[i] == k)
                    result += 1;
            }
        }
        return result;
    }
}

// 560. Subarray Sum Equals K
// Time: O(n)
// Space: O(n)
// Java

public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //sum, cnt
        map.put(0, 1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int tmp = sum - k;
            if (map.containsKey(tmp))
                result += map.get(tmp);
            
            if (map.containsKey(sum))
                map.put(sum, map.get(sum)+1);
            else
                map.put(sum, 1);
            
        }
        return result;
    }
}

