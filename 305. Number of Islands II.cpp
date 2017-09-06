class Solution {
public:
    vector<int> numIslands2(int m, int n, vector<pair<int, int>>& positions) {
        vector<int> res;
        if (m <= 0 || n <= 0) return res;
        vector<int> roots(m * n, -1);
        int cnt = 0;
        vector<vector<int> > dirs{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (auto a : positions) {
            int id = n * a.first + a.second;
            roots[id] = id;//initial the id to itself
            ++cnt;
            for (auto d : dirs) {
                int x = a.first + d[0], y = a.second + d[1];
                int cur_id = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[cur_id] == -1) 
					continue;
                int new_id = findRoots(roots, cur_id);
                if (id != new_id) {
                    roots[id] = new_id;//set the id to root's id
                    id = new_id;//change the cur_position to root
                    --cnt;
                }
            }
            res.push_back(cnt);
        }
        return res;
    }
    int findRoots(vector<int> &roots, int id) {
        while (id != roots[id]) {//compress path
            roots[id] = roots[roots[id]];//jump one step
            id = roots[id];
        }
        return id;
    }
};