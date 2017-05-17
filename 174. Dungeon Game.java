public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {  
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        //before step into (i, j), the minimum power needed for survive
        int[][] map = new int[m][n];
        
        map[m-1][n-1] = dungeon[m-1][n-1] > 0? 1 : -dungeon[m-1][n-1]+1;
        
        for (int i = m-2; i >= 0; i--) {
            if (dungeon[i][n-1] > 0) {
                map[i][n-1] = map[i+1][n-1]-dungeon[i][n-1] > 0? map[i+1][n-1]-dungeon[i][n-1] : 1;
            }
            else {
                map[i][n-1] = map[i+1][n-1]-dungeon[i][n-1];
            }
        }
        
        for (int j = n-2; j >= 0; j--) {
            if (dungeon[m-1][j] > 0) {
                map[m-1][j] = map[m-1][j+1]-dungeon[m-1][j] > 0? map[m-1][j+1]-dungeon[m-1][j] : 1;
            }
            else {
                map[m-1][j] = map[m-1][j+1]-dungeon[m-1][j];
            }
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int downCost = 0;
                int rightCost = 0;
                if (dungeon[i][j] > 0) {
                    downCost = map[i+1][j]-dungeon[i][j] > 0? map[i+1][j]-dungeon[i][j] : 1;
                    rightCost = map[i][j+1]-dungeon[i][j] > 0? map[i][j+1]-dungeon[i][j] : 1;
                }
                else {
                    downCost = map[i+1][j]-dungeon[i][j];
                    rightCost = map[i][j+1]-dungeon[i][j];
                }
                map[i][j] = Math.min(downCost, rightCost);
            }
        }
        
        return map[0][0];
    }  
}