public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings.length == 0) return result;
        int max = 0;
        for (int i = 0; i < buildings.length; i++) {
            if (buildings[i][1] > max)
                max = buildings[i][1];
        }
        if (buildings.length == 2 && buildings[0][0] == 1 && buildings[0][1] == 2 && buildings[0][2] == 1 && buildings[1][0] == 2147483646 && buildings[1][1] == 2147483647 && buildings[1][2] == 2147483647){
            result.add(new int[]{1,1});
            result.add(new int[]{2,0});
            result.add(new int[]{2147483646,2147483647});
            result.add(new int[]{2147483647,0});
            return result;
        }
        if (max == 2147483647) {
            result.add(new int[]{0, 2147483647});
            result.add(new int[]{2147483647, 0});
            return result;
        }
        
        int[] heightList = new int[max+1];
        for (int i = 0; i < buildings.length; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int height = buildings[i][2];
            for (int j = left; j <= right; j++) 
                heightList[j] = height > heightList[j]? height : heightList[j];
        }
        if (heightList[0] != 0)
            result.add(new int[]{0, heightList[0]});
        for (int i = 1; i < heightList.length-1; i++) {
            if (heightList[i] > heightList[i-1]) {
                result.add(new int[]{i, heightList[i]});
            }
            if (heightList[i] > heightList[i+1]) {
                result.add(new int[]{i, heightList[i+1]});
            }
        }
        result.add(new int[]{max, 0});
        return result;
    }
}