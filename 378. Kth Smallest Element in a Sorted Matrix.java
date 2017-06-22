public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }
    
    private int getLessEqual(int[][] matrix, int val) {
        int result = 0;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] > val) 
                i--;
            else {
                result += i + 1;
                j++;
            }
        }
        return result;
    }
}