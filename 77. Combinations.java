public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n == 0) return result;
        
        for (int i = 1; i <= n-k+1; i++) {
            List<Integer> newResult = new ArrayList<>();
            newResult.add(i);
            result.add(newResult);
        }
        
        int cnt = k-1;
        while (cnt != 0){
            int resultSize = result.size();
            while (resultSize != 0) {
                resultSize--;
                List<Integer> newResult = new ArrayList<>();
                newResult = result.get(0);
                result.remove(0);
                int tmp = newResult.get(newResult.size()-1)+1;
                for (int i = tmp; i<=n-cnt+1; i++){
                    //the following two copy method are totally different
                    //List<Integer> newResultCopy = newResult;
                    List<Integer> newResultCopy = new ArrayList<>(newResult);
                    newResultCopy.add(i);
                    result.add(newResultCopy);
                }
            }
            cnt--;
        }
        
        return result;
    }
}