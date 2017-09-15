public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int rowKill = 0;
        int[] colKill = new int[cols];
        
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                // horizontal
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowKill = 0;
                    for (int t = j; t < cols && grid[i][t] != 'W'; t++) {
                        if (grid[i][t] == 'E') rowKill ++;
                    }
                }
                
                // vertical
                if (i == 0 || grid[i-1][j] == 'W') {
                    colKill[j] = 0;
                    for (int t = i; t < rows && grid[t][j] != 'W'; t++) {
                        if (grid[t][j] == 'E') colKill[j] ++;
                    }
                }
                
                int tempTotal = rowKill + colKill[j];
                if (grid[i][j] == '0') {
                    res = Math.max(res, tempTotal);
                }
            }
        }
        
        return res;
    }
}