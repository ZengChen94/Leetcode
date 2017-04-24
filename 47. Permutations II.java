public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        ArrayList<Integer> tmpResult = new ArrayList<Integer>();
        result.add(tmpResult);
        
        Arrays.sort(nums);
        //the order of permulation doesn't count too much
        //to avoid duplicate, we need to make the right order as for the same element
        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            int size = result.size();
            for (; size > 0; size--) {
                List<Integer> r = result.get(0);
                result.remove(0);
                
                int start = 0;
                if (j > 0 && nums[j] == nums[j-1]){
                    for (int k = r.size()-1; k >= 0; k--){
                        if (r.get(k) == n){
                            start = k+1;
                            break;
                        }
                    }
                }
                
                for (int i = start; i <= r.size(); i++) {
                    List<Integer> tmp = new ArrayList<Integer>(r);
                    tmp.add(i, n);
                    //if (result.contains(tmp) != true)
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}