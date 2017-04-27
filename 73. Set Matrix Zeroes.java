public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false,firstCol = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) firstRow = true; // whether row0 has 0
                    if(j == 0) firstCol = true; // whether column0 has 0
                    matrix[0][j] = 0; // mark which column should be 0
                    matrix[i][0] = 0; // mark which row should be 0
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstCol) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}