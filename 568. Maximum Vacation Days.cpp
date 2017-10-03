class Solution {
public:
    int maxVacationDays(vector<vector<int>>& flights, vector<vector<int>>& days) {
        int city_cnt = days.size();
        int week_cnt = days[0].size();
        // DP array
        vector<vector<int>> dp(week_cnt, vector<int>(city_cnt, -1));
        // DP initialize status
        // O(N)
        for(int i = 0; i < city_cnt; i++){
            if(flights[0][i] == 1 || i == 0){
                dp[0][i] = days[i][0];
            }
        }
        // DP , O(N*K*K)
        // start from week 1
        // for each city, find whic on can reach current city
        for(int week = 1; week < week_cnt; week++){
            for(int city = 0; city < city_cnt; city++){
                for(int i = 0; i < city_cnt; i++){
                    // dp[week - 1][i] != -1: this city has been visited
                    if(dp[week - 1][i] != -1 && (flights[i][city] == 1 || i == city)){
                        dp[week][city] = max(dp[week][city], dp[week - 1][i] + days[city][week]);
                    }
                }
            }
        }
        // return the maximum value from last week
        return *max_element(dp[week_cnt - 1].begin(), dp[week_cnt - 1].end());
    }
};