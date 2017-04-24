public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(board, 0, result);
        return result;
    }
    
    public void dfs(char[][] board, int col, List<List<String>> result) {
        if (col == board.length) {
            result.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[i][col] = 'Q';
            if (valid(board, i, col))
                dfs(board, col+1, result);
            board[i][col] = '.';
        }
    }
    
    public boolean valid(char[][] board, int row, int col){
        for (int i = 0; i < board.length; i++){
            if (i == col)
                continue;
            if (board[row][i] == 'Q')
                return false;
        }

        for (int i = 1; i+col < board.length && i+row < board.length; i++){
            if (board[i+row][i+col] == 'Q')
                return false;
        }
        for (int i = 1; col-i >= 0 && row-i >= 0; i++){
            if (board[row-i][col-i] == 'Q')
                return false;
        }
        for (int i = 1; i+row < board.length && col-i >= 0; i++){
            if (board[i+row][col-i] == 'Q')
                return false;
        }
        for (int i = 1; row-i >= 0 && col+i < board.length; i++){
            if (board[row-i][col+i] == 'Q')
                return false;
        }
        return true;
    } 
    
    List<String> construct(char[][] board) {
        List<String> result = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            result.add(s);
        }
        return result;
    }
}