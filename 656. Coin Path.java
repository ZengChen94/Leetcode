public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        if (A.length == 0 || A[A.length-1] == -1 || A[0] == -1) 
            return res;
        if (A.length==1) {
            res.add(1); 
            return res;
        }
        int[] cost = new int[A.length];  //keep track of cost
        int[] trace = new int[A.length];  //keep track of prev element
        int[] len = new int[A.length];  //keep track of sequence length to reach an element
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(trace, -1);
        cost[0] = 0;
        len[0] = 1;
        for (int i = 1; i < A.length; i++){
            if (A[i] == -1) continue;
            /*
            We trace from i-B to i-1 to get the min lexi result 
            for example, in [1,3,2,4], 2, then [1,2,4] is smaller than [1,3,4]
            */
            for (int j = Math.max(i-B, 0); j < i; j++){
                //we want the min cost
                if (cost[j] != Integer.MAX_VALUE && cost[j] + A[j] < cost[i]){
                    cost[i] = cost[j] + A[j];
                    trace[i] = j;
                    len[i] = len[j] + 1;
                }
                //if the cost is same but our new sequence is longer than our prev one, note j < i, so add j before i in the sequence will definitely get a lexi smaller result
                else if (cost[j] != Integer.MAX_VALUE && cost[j] + A[j] == cost[i]){
                    if (len[j] + 1 > len[i]){
                        len[i] = len[j] + 1;
						trace[i] = j;
                    }
                }
            }
        }
        int cur = A.length - 1;
        if (trace[cur] == -1) 
            return res;
        while (cur != 0){
            res.add(0, cur+1);
            cur = trace[cur];
        }
        res.add(0, 1);
        return res;
    }
}