class Solution {
public:
    string nearestPalindromic(string n) {
        if(n.empty()) return n ;
        if(n.size() == 1){
            n[0] -= 1 ;
            return n ;
        }
        vector<string> cand ;
        //比n少一位的“99……99”
        cand.push_back(string(n.size() - 1 , '9')) ;

        //比n多一位的“10000……00001”
        string str = n ;
        str[0] = '1' ;
        for(int i = 1 ; i < str.size() ; ++i)
            str[i] = '0' ;
        str.push_back('1') ;
        cand.push_back(str) ;

        //把原字符串变为Palindrome
        str = n ;
        cand.push_back(make_pa(str)) ;
        //把中间字符加一变为Palindrome
        int mid = (str.size() - 1)/2 ;
        str[mid] += 1 ;
        //把中间字符减一变为Palindrome
        cand.push_back(make_pa(str)) ;
        str[mid] -= 2 ;
        cand.push_back(make_pa(str)) ;

        //选取距离最近的那个候选字符串
        long diff = INT_MAX , mark = 0 , temp ;
        for(int i = 0 ; i < cand.size() ; ++i){
            temp = make_diff(cand[i] , n) ;
            if(temp > 0 && temp < diff){
                mark = i ;
                diff = temp ;
            }
            //如果有等距离的，取小的那个
            else if(temp > 0 && temp == diff){
                if(atol(cand[i].c_str()) < atol(cand[mark].c_str())) mark = i ;
            }
        }
        return cand[mark] ;
    }

    //字符串转变为数值然后做差
    long make_diff(string s , string n){
        long count_s = atol(s.c_str()) , count_n = atol(n.c_str()) ;
        return abs(count_s - count_n) ;
    }

    //将字符串变为Palindrome
    string make_pa(string str){
        for(int i = str.size() - 1, j = 0 ; i > (str.size() - 1)/2 ; --i , ++j)
            if(str[i] != str[j]) str[i] = str[j] ;
        return str ;
    }

};