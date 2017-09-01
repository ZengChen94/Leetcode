class WordDistance {
private:
    unordered_map<string, vector<int>> wordidx;
public:
    WordDistance(vector<string>& words) {
        int n = words.size();
        for (int i = 0; i < n; ++i) wordidx[words[i]].push_back(i);
    }

    int shortest(string word1, string word2) {
        vector<int> &idx1 = wordidx[word1];
        vector<int> &idx2 = wordidx[word2];
        int m = idx1.size(), n = idx2.size();
        int res = INT_MAX, i = 0, j = 0;
        while (i < m && j < n) {
            res = min(res, abs(idx1[i] - idx2[j]));
            if (idx1[i] > idx2[j]) ++j;
            else ++i;
        }
        return res;
    }
};


// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");