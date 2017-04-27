public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
    	
    	int begin = 0, end = matrix.length * matrix[0].length - 1;
    	
    	while(begin <= end){
    		int mid = (begin + end) / 2;
    		int mid_value = matrix[mid/matrix.length][mid%matrix[0].length];
    		
    		if(mid_value == target)
    			return true;
    		else if(mid_value < target)
    			begin = mid + 1;
    		else
    			end = mid - 1;
    	}
    	return false;
    }
}