class Solution {
    public int total = 0;
    
    public int pathSum(int[] nums) {
        if (nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i]/10, nums[i]%10);
        }
        helper(1, 1, map, map.get(11));
        return total;
    }
    
    void helper(int level, int index, Map<Integer, Integer> map, int cnt) {
        int key1 = (level+1)*10+index*2-1;
        int key2 = (level+1)*10+index*2;
        if (!map.containsKey(key1) && !map.containsKey(key2)) {
            total += cnt;
            return;
        }
        if (map.containsKey(key1)) {
            helper(level+1, index*2-1, map, cnt+map.get(key1));
        }
        if (map.containsKey(key2)) {
            helper(level+1, index*2, map, cnt+map.get(key2));
        }
        return;
    }
}