class Solution {
public:
    vector<string> generatePalindromes(string s) {
        vector<string> res;
        unordered_map<char, int> m;
        string t = "", mid = "";
        for (auto a : s) ++m[a];
        for (auto &it : m) {
            if (it.second % 2 == 1) mid += it.first;
            it.second /= 2;
            t += string(it.second, it.first);
            if (mid.size() > 1) return {};
        }
        permute(t, m, mid, "", res);
        return res;
    }
    void permute(string &t, unordered_map<char, int> &m, string mid, string out, vector<string> &res) {
        if (out.size() >= t.size()) {
            res.push_back(out + mid + string(out.rbegin(), out.rend()));
            return;
        } 
        for (auto &it : m) {
            if (it.second > 0) {
                --it.second;
                permute(t, m, mid, out + it.first, res);
                ++it.second;
            }
        }
    }
};