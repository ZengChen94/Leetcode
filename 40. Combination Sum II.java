public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++){
            List<Integer> sumList = new ArrayList<Integer>();
            sumList.add(candidates[i]);
            if (candidates[i] < target)
                result = combine(candidates, target, candidates[i], i, sumList, result);
            else if (candidates[i] == target)
                result.add(sumList);
            else
                continue;
        }
        List<List<Integer>> result2 = new ArrayList<>();
        for (int i = 0; i < result.size(); i++){
        	if (!result2.contains(result.get(i)))
        		result2.add(result.get(i));
        }
        return result2;
    }
    public List<List<Integer>> combine(int[] candidates, int target, int sum, int index, List<Integer> sumList, List<List<Integer>> result) {
        for (int i = index+1; i < candidates.length; i++){
            if (sum + candidates[i] == target){
                sumList.add(candidates[i]);
                result.add(sumList);
                return result;
            }
            else if (sum + candidates[i] < target){
                List<Integer> sumListCopy = new ArrayList<Integer>(sumList);
                sumList.add(candidates[i]);
                combine(candidates, target, sum + candidates[i], i, sumList, result);
                sumList = sumListCopy;
            }
            else
                return result;
        }
        return result;
    }
}