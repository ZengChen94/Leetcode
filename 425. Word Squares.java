public class Solution {
    class Node{
        String word = null;
        Node[] kids = new Node[26];
    }
    
    private Node root = new Node();
    
    private void buildTrie(String word, Node par){
        for(char c: word.toCharArray()){
            int idx = c -'a';
            if(par.kids[idx] == null) par.kids[idx] = new Node();
            par = par.kids[idx];
        }
        par.word = word;
    }
    
    private void findAllSquares(int row , int col, Node[] prefix, List<List<String>> res){
        if(row == prefix.length){
            List<String> temp = new ArrayList<String>();
            for(int i=0; i<prefix.length; i++){
                temp.add(prefix[i].word);
            }
            res.add(temp);
        } else if(col < prefix.length){ 
            Node currow = prefix[row];  
            Node curcol = prefix[col];
            for(int i=0; i<26; i++){
                if(currow.kids[i] != null && curcol.kids[i] != null){   // 同一层从左向右走的时候
                    prefix[row] =  currow.kids[i];      //  prefix[row]会不断增长，直到最后形成以个单词
                    prefix[col] =  curcol.kids[i];      //  prefix[col]相应位置长度加一，更新prefix
                    findAllSquares(row, col+1, prefix, res);   
                }
            }
            prefix[row] = currow;       // reset back  重新进行下一次的搜索。
            prefix[col] = curcol;
        } else {
            findAllSquares(row+1, row+1, prefix, res);
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(words == null || words.length == 0 || words[0] == null || words[0].length() == 0) return res;
        for(String word: words){
            buildTrie(word, root);
        }
        Node[] prefix = new Node[words[0].length()];
        Arrays.fill(prefix, root);
        findAllSquares(0, 0, prefix, res);
        return res;
    }
}