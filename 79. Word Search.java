public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == "") return true;
        if (board.length == 0) return false;
        
        boolean[][] visit = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0))
                    if (dfs(i, j, 0, visit, board, word))
                        return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int index, boolean[][] visit, char[][] board, String word){
        if (index == word.length()-1) return true;
        visit[i][j] = true;
        index += 1;
        if (i-1>=0 && board[i-1][j]==word.charAt(index) && visit[i-1][j]==false)
            if (dfs(i-1, j, index, visit, board, word))
                return true;
        if (i+1<=board.length-1 && board[i+1][j]==word.charAt(index) && visit[i+1][j]==false)
            if (dfs(i+1, j, index, visit, board, word))
                return true;
        if (j-1>=0 && board[i][j-1]==word.charAt(index) && visit[i][j-1]==false)
            if (dfs(i, j-1, index, visit, board, word))
                return true;
        if (j+1<=board[0].length-1 && board[i][j+1]==word.charAt(index) && visit[i][j+1]==false)
            if (dfs(i, j+1, index, visit, board, word))
                return true;
        visit[i][j] = false;
        
        return false;
    }
}