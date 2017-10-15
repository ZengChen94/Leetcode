class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
            max = Math.max(max, map.get(nums[i]));
        }
        if (max == 1) return 1;
        int length = Integer.MAX_VALUE;
        map = new HashMap<Integer, Integer>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
            if (map.get(nums[i]) == max) {
                while (nums[j] != nums[i] && j < i) {
                    map.put(nums[j], map.get(nums[j])-1);
                    j++;
                }
                length = Math.min(length, i-j+1);
                map.put(nums[j], map.get(nums[j])-1);
                j++;
            }
        }
        return length;
    }
}