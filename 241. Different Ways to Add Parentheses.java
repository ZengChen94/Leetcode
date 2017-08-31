public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+' ) {
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));//iterative
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for (Integer p1 : part1) {
                    for (Integer p2 : part2) {
                        int c = 0;
                        if (input.charAt(i) == '+')
                            c = p1 + p2;
                        else if (input.charAt(i) == '-')
                            c = p1 - p2;
                        else if (input.charAt(i) == '*')
                            c = p1 * p2;
                        result.add(c);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}