class Solution {
    public List<String> letterCasePermutation(String S) {
        String s = S;
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            res.add(s);
            return res;
        }
        HashSet<String> hs = new HashSet<>();
        helper(s.toCharArray(),0,hs,res);
        return res;
    }
    
    public static void helper(char[] stc,int i,HashSet<String> hs,List<String> res){
        if(i >= stc.length)
            return;
        String s = new String(stc);
        if(!hs.contains(s)){
            hs.add(s);
            res.add(s);
        }        
        helper(stc,i+1,hs,res);
        char c = s.charAt(i);
        if(!Character.isDigit(c)){
            if(c > 90){
                    stc[i] = Character.toUpperCase(c);
            }else{
                stc[i] = Character.toLowerCase(c);
            }
            String temp = new String(stc);
            if(!hs.contains(temp)){
                hs.add(temp);
                res.add(temp);
                helper(stc,i+1,hs,res);
            }
        }        
    }
}