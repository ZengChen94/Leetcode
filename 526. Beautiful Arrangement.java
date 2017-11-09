public class Solution {
    int count = 0;
    
    public int countArrangement(int N) {
        if (N == 0) 
            return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }
    
    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}

public class Solution {
    int cnt = 0;
    
    public int countArrangement(int N) {
        if (N == 0) 
            return 0;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = i+1;
        helper(nums, N-1);
        return cnt;
    }
    
    public void helper(int[] nums, int index) {
        if (index == 0) {
            cnt += 1;
            return;
        }
        
        for (int i = index; i >= 0; i--) {
            if (nums[i] % (index+1) == 0 || (index+1) % nums[i] == 0) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                helper(nums, index-1);
                tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }
        
        return;
    }
}