public class Solution {
    
    char[] table = {'0', '1', '8', '6', '9'};
    List<String> res;
    
    public List<String> findStrobogrammatic(int n) {
        res = new ArrayList<String>();
        build(n, "");
        return res;
    }
    
    public void build(int n, String tmp){
        if(n == tmp.length()){
            res.add(tmp);
            return;
        }
        boolean last = n - tmp.length() == 1;
        for(int i = 0; i < table.length; i++){
            char c = table[i];
            if((n != 1 && tmp.length() == 0 && c == '0') || (last && (c == '6' || c == '9'))){
                continue;
            }
            StringBuilder newTmp = new StringBuilder(tmp);
            append(last, c, newTmp);
            build(n, newTmp.toString());
        }
    }
    
    public void append(boolean last, char c, StringBuilder sb){
        if(c == '6'){
            sb.insert(sb.length()/2, "69");
        } else if(c == '9'){
            sb.insert(sb.length()/2, "96");
        } else {
            sb.insert(sb.length()/2, last ? c : ""+c+c);
        }
    }
}