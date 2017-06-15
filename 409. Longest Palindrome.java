public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp))
                map.put(tmp, map.get(tmp)+1);
            else
                map.put(tmp, 1);
        }
        int cnt = 0;
        int flag = 0;
        for (int value : map.values()) {
            if (value % 2 == 0)
                cnt += value;
            else {
                flag = 1;
                cnt += (value-1);
            }
        }
        if (flag == 1)
            cnt += 1;
        return cnt;
    }
}

public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (set.contains(tmp)) {
                cnt += 1;
                set.remove(tmp);
            }
            else
                set.add(tmp);
        }
        if (set.isEmpty())
            return cnt * 2;
        else
            return cnt * 2 + 1;
    }
}

public class Solution {
    public int longestPalindrome(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if (tmp >= 'a' && tmp <= 'z') 
                lowercase[tmp-'a']++;
            else 
                uppercase[tmp-'A']++;
        }
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            if (lowercase[i] % 2 == 0)
                result += lowercase[i];
            else {
                result += lowercase[i]-1;
                flag = 1;
            }
            if (uppercase[i] % 2 == 0)
                result += uppercase[i];
            else {
                result += uppercase[i]-1;
                flag = 1;
            }
        }
        return flag == 1? result + 1 : result;
    }
}