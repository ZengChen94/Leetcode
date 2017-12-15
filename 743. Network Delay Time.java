class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] delay = new int[N + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        Integer[][] edge = new Integer[101][101];
        for (int[] e : times) 
            edge[e[0]][e[1]] = e[2];
        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        delay[K] = 0;
        while (!q.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            for (int n = q.size(); n > 0; n--) {
                int u = q.poll();
                for (int v = 1; v <= 100; v++) {
                    if (edge[u][v] != null && delay[u] + edge[u][v] < delay[v]) {
                        if (!set.contains(v)) {
                            set.add(v);
                            q.offer(v);
                        }
                        delay[v] = delay[u] + edge[u][v];
                    }
                }
            }
        }
        int maxdelay = 0;
        for (int i = 1; i <= N; i++)
            maxdelay = Math.max(maxdelay, delay[i]);

        return maxdelay == Integer.MAX_VALUE ? -1 : maxdelay;
    }
}