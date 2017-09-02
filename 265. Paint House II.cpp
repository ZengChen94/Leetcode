class Solution {  
public:  
    int minCostII(vector<vector<int>>& costs) {  
        if(costs.size() == 0) return 0;  
        int m = costs.size(), n = costs[0].size();  
        vector<int> dp(costs[0]);  
        for(int i = 1; i < m; i++)  
        {  
            vector<int> left(n, INT_MAX), right(n, INT_MAX);  
			//here we optimize the complexity of time from O(n*k*k) to O(n*k)
            for(int j =1; j< n; j++)     
                left[j] = min(left[j-1], dp[j-1]);  
            for(int j =n-2; j>=0; j--)   
                right[j] = min(right[j+1], dp[j+1]);   
            for(int j =0; j< n; j++)  
                dp[j] = min(left[j], right[j]) + costs[i][j];  
        }  
        return *min_element(dp.begin(), dp.end());  
    }  
};  