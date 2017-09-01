class Solution {  
public:  
    void DFS(string& low, string& high, int n, string str)  
    {  
        if(n == 0 && stol(str) >= stol(low) && stol(str) <= stol(high)) {Max++; return;}  
        if(n % 2 == 1) for(auto val : same) DFS(low, high, n-1, val);  
        if(n == 0 || n % 2 == 1) return;  
        for(int i = (n == 2 ? 1 : 0); i < two.size(); i++)  
            DFS(low, high, n-2, two[i].first+str+two[i].second);  
    }  
      
    int strobogrammaticInRange(string low, string high) {  
        int n1 = low.size(), n2 = high.size();  
        for(int i = n1; i <= n2; i++) DFS(low, high, i, "");  
        return Max;  
    }  
private:  
    int Max = 0;  
    vector<string> same{"0", "1", "8"};  
    vector<pair<char,char>> two{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};  
};  