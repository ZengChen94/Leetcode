public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> resultTmp = new ArrayList<>();
        int[][] map = new int[s.length()+1][s.length()+1];//0--not visit / 1--visit&true / 2-visit&false
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i)) == true){
                map[0][i] = 1;
                resultTmp.add(s.substring(0, i));
                helper(s, i, result, resultTmp, map);
                resultTmp.remove(resultTmp.size()-1);
            }
        }
        return result;
    }
    
    public void helper(String s, int pos, List<List<String>> result, List<String> resultTmp, int[][] map) {
        if (pos == s.length()){
            result.add(new ArrayList<>(resultTmp));
            return;
        }
        for (int i = pos+1; i <= s.length(); i++) {
            if (map[pos][i] == 1){
                resultTmp.add(s.substring(pos, i));
                helper(s, i, result, resultTmp, map);
                resultTmp.remove(resultTmp.size()-1);
            }
            else if (map[pos][i] == 2)
                continue;
            else if (isPalindrome(s.substring(pos, i)) == true){
                map[pos][i] = 1;
                resultTmp.add(s.substring(pos, i));
                helper(s, i, result, resultTmp, map);
                resultTmp.remove(resultTmp.size()-1);
            }
            else {
                map[pos][i] = 2;
            }
        }
        return;
    }
    
    public boolean isPalindrome(String str){
        int lower = 0;
        int upper = str.length()-1;
        if(lower == upper) return true;
        while(lower < upper){
            if(str.charAt(lower) != str.charAt(upper)) return false;
            lower++;
            upper--;
        }
        return true;
    }
}

public class Solution {
	List<List<String>> resultLst;
	ArrayList<String> currLst;
	public List<List<String>> partition(String s) {
		resultLst = new ArrayList<List<String>>();
		currLst = new ArrayList<String>();
		backTrack(s,0);
		return resultLst;
	}
	public void backTrack(String s, int l){
		if(currLst.size()>0 //the initial str could be palindrome
			&& l>=s.length()){
				List<String> r = (ArrayList<String>) currLst.clone();
				resultLst.add(r);
		}
		for(int i=l;i<s.length();i++){
			if(isPalindrome(s,l,i)){
				if(l==i)
					currLst.add(Character.toString(s.charAt(i)));
				else
					currLst.add(s.substring(l,i+1));
				backTrack(s,i+1);
				currLst.remove(currLst.size()-1);
			}
		}
	}
	public boolean isPalindrome(String str, int l, int r){
		if(l==r) return true;
		while(l<r){
			if(str.charAt(l)!=str.charAt(r)) return false;
			l++;r--;
		}
		return true;
	}
}