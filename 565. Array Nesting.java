public class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        int cnt = 0;
        int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == false) {
                int tmp = i;
                cnt = 0;
                set.clear();
                while (!set.contains(tmp)) {
                    set.add(tmp);
                    visit[tmp] = true;
                    tmp = nums[tmp];
                    cnt++;
                }
                max = cnt > max? cnt : max;
            }
        }
        return max;
    }
}

//Space: O(1)
public class Solution {
    public int arrayNesting(int[] nums) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = 0;
            for (int j = i; nums[j] >= 0; ) {
                cnt++;
                int tmpj = nums[j];
                nums[j] = -1;
                j = tmpj;
                if (j == i)
                    break;
            }
            max = cnt > max? cnt : max;
        }
        return max;
    }
}
