public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        int diff = 1;//diff = outdegree - indegree
        for (int i = 0; i < array.length; i++) {
            diff -= 1;
            if (diff < 0) return false;
            if (!array[i].equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}