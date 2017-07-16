public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] tmp = log.split(":");
            int id = Integer.parseInt(tmp[0]);
            int time = Integer.parseInt(tmp[2]);
            if (tmp[1].equals("start")) {
                stack1.push(id);
                stack2.push(time);
            }
            else {
                int tmp2 = time - stack2.pop() + 1;
                res[id] += tmp2 - last;
            }
        }
        return res;
    }
}