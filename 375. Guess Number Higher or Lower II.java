//dp
public class Solution {
    public int getMoneyAmount(int n) {  
        int[][] matrix = new int[n+1][n+1];  
        return pay(matrix, 1, n);  
    }  
    public int pay(int[][] matrix, int start, int end){  
        if(start >= end){  
            return 0;  
        }  
        if(matrix[start][end] != 0){  
            return matrix[start][end];  
        }  
        int ans = Integer.MAX_VALUE;  
        for(int mid = start; mid <= end; mid++){  
			//2-dimension array can also represeant interval
            int test = mid + Math.max(pay(matrix, start, mid-1), pay(matrix, mid+1, end));  
            if(test < ans){  
                ans = test;  
            }  
        }  
        matrix[start][end] = ans;  
        return ans;  
    }  
}