public class Solution {
    public int findMaxLength(int[] nums) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1)
                tmp++;
            else
                tmp--;
            if (!map.containsKey(tmp))
                map.put(tmp, i);
            else
                cnt = Math.max(i - map.get(tmp), cnt);
        }
        return cnt;
    }
}