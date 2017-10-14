class Solution {  
public:  
    string minAbbreviation(string target, vector<string>& dictionary) {  
        int len = target.size();  
        if(len == 0) return "";  
        vector<string> dic;  
		// only the one has the same originally length, they may confict
        for(string s:dictionary) {  
            if(s.size() == len) {  
                dic.push_back(s);  
            }  
        }  
        int len_d = dic.size();  
        if(len_d == 0) 
			return intTostring(len);  
        string res = target;  
        dfs("", 0, target, 0, dic, res, len);  
        return res;  
    }  
  
    void dfs(string cur, int cur_len, string& target, int pos, vector<string>& dic, string& res, int& minlen) {  
        if(pos >= (int)target.size()) {  
            if(cur_len < minlen) {  //¼ôÖ¦  
                bool f = true;  
                for(string s : dic) {  
                    if(check(s, cur)) {  
                        f = false;
						break;  
                    }  
                }  
                if(f){  
                    res = cur;  
                    minlen = cur_len;  
                }  
            }  
            return;  
        }  
        if(minlen == cur_len) return;   //¼ôÖ¦  
        if(cur.empty() || !isdigit(cur.back())) {   //  
            for(int i = target.size()-1; i >= pos; i--) {  
                 string add = intTostring(i-pos+1);  
                 dfs(cur+add, cur_len+1, target,i+1, dic, res, minlen);  
            }  
        }  
        dfs(cur+target[pos], cur_len+1, target,pos+1, dic, res, minlen);  
    }  
  
    bool check(string s1, string s2) {  
        int len1 = s1.size();  
        int len2 = s2.size();  
        int l = 0,r = 0;  
        while(l < len1 && r < len2) {  
            if(isdigit(s2[r])) {  
                int dis = 0;  
                while(r < len2 && isdigit(s2[r])) {  
                    dis = dis * 10 + s2[r++] - '0';  
                }  
                l+=dis;  
            }  
            else if(s2[r] == '0') 
				return false;  
            else {  
                if(s1[l] == s2[r]) {  
                    l++;
					r++;  
                }  
                else return false;  
            }  
         }  
         if(l >= len1 && r >= len2) 
			 return true;  
         return false;  
    }  
  
    string intTostring(int num) {  
        stringstream ss;  
        ss<<num;  
        return ss.str();  
    }  
};  