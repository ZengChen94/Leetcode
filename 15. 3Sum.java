public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>(); 
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length-1;
            int sum = 0;
            while (j < k) {
                if (nums[i]+nums[j]+nums[k] < 0) {
                    j++;
                    while (nums[j] == nums[j-1] && j<k) j++;
                }
                else if (nums[i]+nums[j]+nums[k] > 0) {
                    k--;
                    while (nums[k] == nums[k+1] && j<k) k--;
                }
                else {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    j++; k--;
                    while (nums[j] == nums[j-1] && nums[k] == nums[k+1] && j<k) j++;
                }
            }
        }
        return result;
    }
}