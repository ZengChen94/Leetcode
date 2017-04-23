public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        ArrayList<Integer> tmpResult = new ArrayList<Integer>();
        result.add(tmpResult);
        
        //the order of permulation doesn't count too much
        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            int size = result.size();
            for (; size > 0; size--) {
                List<Integer> r = result.get(0);
                result.remove(0);
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> tmp = new ArrayList<Integer>(r);
                    tmp.add(i, n);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}