public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0; 
        if (nums.length < 3) return result;
        int gap = nums[0]+nums[1]+nums[2] > target ? nums[0]+nums[1]+nums[2] - target : -(nums[0]+nums[1]+nums[2] - target);
        result = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                if (nums[i]+nums[j]+nums[k]<target){
                    if (target-(nums[i]+nums[j]+nums[k])<gap){
                        result = nums[i]+nums[j]+nums[k];
                        gap = target-result;
                    }
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>target){
                    if ((nums[i]+nums[j]+nums[k])-target<gap){
                        result = nums[i]+nums[j]+nums[k];
                        gap = result-target;
                    }
                    k--;
                }
                else{
                    return target;
                }
            }
        }
        return result;
    }
}