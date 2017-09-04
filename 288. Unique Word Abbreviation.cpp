//method2
//unordered_map<string, set<string>> m;
class ValidWordAbbr {
public:
    ValidWordAbbr(vector<string> &dictionary) {
        for (auto a : dictionary) {
            string k = a[0] + to_string(a.size() - 2) + a.back();
            m[k].insert(a);
        }
    }
    bool isUnique(string word) {
        string k = word[0] + to_string(word.size() - 2) + word.back();
        return m[k].count(word) == m[k].size();
    }
private:
    unordered_map<string, set<string>> m;
};

//method2
//我们在遇到哈希表中没有当前缩写形式的时候，将该缩写形式和当前单词建立映射
//如果该缩写形式应经存在，那么我们看如果映射的单词不是当前单词，我们将映射单词改为空字符串
class ValidWordAbbr {
public:
    ValidWordAbbr(vector<string> &dictionary) {
        for (auto a : dictionary) {
            string k = a[0] + to_string(a.size() - 2) + a.back();
            if (m.find(k) != m.end() && m[k] != a) m[k] = "";
            else m[k] = a;
        }
    }
    bool isUnique(string word) {
        string k = word[0] + to_string(word.size() - 2) + word.back();
        return m.find(k) == m.end() || m[k] == word;
    }
private:
    unordered_map<string, string> m;
};