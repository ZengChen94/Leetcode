class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int left = target-nums[i];
            if (!map.containsKey(left)) {
                continue;
            }
            else {
                int j = map.get(left);
                if (j != i) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            if (nums[i] + nums[j] == target)
                break;
            else if (nums[i] + nums[j] > target)
                j--;
            else
                i++;
        }
        return new int[]{i, j};
    }
}