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
//������������ϣ����û�е�ǰ��д��ʽ��ʱ�򣬽�����д��ʽ�͵�ǰ���ʽ���ӳ��
//�������д��ʽӦ�����ڣ���ô���ǿ����ӳ��ĵ��ʲ��ǵ�ǰ���ʣ����ǽ�ӳ�䵥�ʸ�Ϊ���ַ���
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