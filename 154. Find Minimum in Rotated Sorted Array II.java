public class Solution {
    public int findMin(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        
        int index = 0;
        for (int i = 1; i < nums.length; i++){//this method seems to be very practical and smart
            if (nums[i] != nums[i-1]){
                index = index + 1;
                nums[index] = nums[i];
            }
        }
        if (nums[index] == nums[0]) index = index - 1;
        
        int start = 0;
        int end = index;
        int mid = 0;
        while (start < end){
            mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];
            
            if (nums[mid] > nums[end]) start = mid + 1;
            else if (nums[mid] < nums[start]) end = mid - 1;
            else return nums[start];
        }
        return nums[start];
    }
}

class Solution {
	public:
		int findMin(vector<int> &num) {
			int lo = 0;
			int hi = num.size() - 1;
			int mid = 0;
			
			while(lo < hi) {
				mid = lo + (hi - lo) / 2;
				
				if (num[mid] > num[hi]) {
					lo = mid + 1;
				}
				else if (num[mid] < num[hi]) {
					hi = mid;
				}
				else { // when num[mid] and num[hi] are same
					hi--;
				}
			}
			return num[lo];
		}
};