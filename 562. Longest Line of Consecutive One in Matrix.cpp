class Solution {
public:
    int longestLine(vector<vector<int>>& M) {
        int max1=0;
        int i,j,m=M.size();
        if(!m) return 0;
        int n=M[0].size();
        vector<vector<int>> dp(n,vector<int>(4,0));
        for(i=0;i<m;i++){
            int old=0;
            for(j=0;j<n;j++){
                if(M[i][j]==1){
                    dp[j][0]=j>0?dp[j-1][0]+1:1;
                    dp[j][1]=i>0?dp[j][1]+1:1;
                    int pre=dp[j][2];
                    dp[j][2]=(j>0&&i>0)?old+1:1;
                    old=pre;
                    dp[j][3]=(i>0&&j<n-1)?dp[j+1][3]+1:1;
                }else{
                    old=dp[j][2];
                    dp[j][0]=dp[j][1]=dp[j][2]=dp[j][3]=0;
                }
                max1=max(max1,max(dp[j][0],max(dp[j][1],max(dp[j][2],dp[j][3]))));
            }
        }
        return max1;
    }
};