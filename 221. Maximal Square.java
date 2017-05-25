public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) 
            return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] map = new int[m][n];
        
        if (matrix[0][0] == '1'){
            map[0][0] = 1;
            result = 1;
        }
            
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                map[i][0] = 1;
                result = 1;
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                map[0][j] = 1;
                result = 1;
            }
        }
        
        for (int i = 1 ; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '1') {
                    map[i][j] = Math.min(Math.min(map[i][j-1] , map[i-1][j-1]), map[i-1][j]) + 1;
                    result = Math.max(map[i][j], result);
                }
            }
        }
        return result*result;
    }
}