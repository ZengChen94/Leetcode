public class Solution {
    //Subsets requires every element be selected 0 or 1 time
    //Subsets2 requires every element be selected 0, 1, 2..., n time
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newResult = new ArrayList<>();
        result.add(newResult);
        if (nums.length == 0)
            return result;
        else
            helper(nums, result, 0);
        return result;
    }
    
    public void helper(int[] nums, List<List<Integer>> result, int pos){
        if (pos == nums.length) return;
        int number = nums[pos];
        int cntNum = 0;
        while (pos < nums.length && number == nums[pos]){
            pos++;
            cntNum += 1;
        }
        int resultSize = result.size();
        for (int i = 0; i < resultSize; i++) {
            List<Integer> getResult = new ArrayList<>(result.get(i));
            for (int j = 1; j <= cntNum; j++){
                getResult.add(number);
                List<Integer> newResult = new ArrayList<>(getResult);
                result.add(newResult);
            }
        }
        helper(nums, result, pos);
    }
}