public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        int k = nums.size(), len = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] ans = null;
        for (int i = 0; i < k; i++) {
            int n = nums.get(i).get(0);
            max = Math.max(max, n);
            minheap.add(new int[]{n, 0, i});
        }
        while (minheap.size() == k) {
            int[] min = minheap.poll();
            if (len > max-min[0]+1) {
                len = max-min[0]+1;
                ans = new int[]{min[0], max};
            }
            if (min[1] < nums.get(min[2]).size()-1) {
                int n = nums.get(min[2]).get(min[1]+1);
                max = Math.max(max, n);
                minheap.add(new int[]{n, min[1]+1, min[2]});
            }
        }
        return ans;
    }
}