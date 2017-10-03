class Solution {  
public:  
    void wiggleSort(vector<int>& nums) {  
        int len = nums.size(), index = 1;  
        if(len == 0) return;  
        for(int i = 0; i < len-1; i++)  
        {  
            if(i % 2 == 0 && nums[i] > nums[i+1])  
                swap(nums[i], nums[i+1]);  
            if(i % 2 == 1 && nums[i] < nums[i+1])  
                swap(nums[i], nums[i+1]);  
        }  
    }  
};  

//method2
public class Solution {
    public void wiggleSort(int[] nums) {
        // 先将数组排序
        Arrays.sort(nums);
        // 将数组中一对一对交换
        for(int i = 2; i < nums.length; i+=2){
            int tmp = nums[i-1];
            nums[i-1] = nums[i];
            nums[i] = tmp;
        }
    }
}