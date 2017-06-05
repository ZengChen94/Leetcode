public class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        
        if (k < 0)
            return 0;
        
        if (k != 0) {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i]))
                    continue;
                int tmp1 = nums[i] - k;
                int tmp2 = nums[i] + k;
                if (set.contains(tmp1))
                    cnt++;
                if (set.contains(tmp2))
                    cnt++;
                set.add(nums[i]); 
            }
        }
        else {
            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i]) && !set2.contains(nums[i])) {
                    set2.add(nums[i]);
                    cnt++;
                }
                set.add(nums[i]); 
            }
        }
        
        return cnt;
    }
}

