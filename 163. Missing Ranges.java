public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        for(int n : nums){
            int justBelow = n - 1;
            if(lower == justBelow) list.add(lower+"");
            else if(lower < justBelow) list.add(lower + "->" + justBelow);
            lower = n+1;
        }
        if(lower == upper) list.add(lower+"");
        else if(lower < upper) list.add(lower + "->" + upper);
        return list;
    }
}