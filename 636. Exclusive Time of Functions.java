public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack1 = new Stack<Integer>();
        //Stack<Integer> stack2 = new Stack<Integer>();
        int preID = -1;
        int preTime = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] tmp = log.split(":");
            int id = Integer.parseInt(tmp[0]);
            int time = Integer.parseInt(tmp[2]);
            if (tmp[1].equals("start")) {
                if (preID == -1) {
                    preID = id;
                }
                else {
                    res[preID] += time - preTime;
                    stack1.push(preID);
                    preID = id;
                    preTime = time;
                }
            }
            else {
                res[preID] += time - preTime;
                //stack1.pop();
                preID = stack1.pop();
                preTime = time;
            }
        }
        return res;
    }
}