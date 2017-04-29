public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int tmp = 1;
        while (n != 0){
            tmp = tmp * 2;
            n--;
        }
        for (int i = 0; i < tmp; i++){
            result.add(i^(i/2));
        }
        return result;
    }
}