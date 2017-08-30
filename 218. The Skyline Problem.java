class Solution {
    public List<int[]> getSkyline(int[][] buildings) {//L, R, H
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});//push(L, -H)
            height.add(new int[]{b[1], b[2]});//push(R, H)
        }
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });//sort accoding to left to right, then from low to high
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));//from large to small
        pq.offer(0);
        int prev = 0;//pre highest
        for(int[] h : height) {
            if(h[1] < 0) {//left --> up
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();//highest
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}