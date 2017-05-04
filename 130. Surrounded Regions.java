public class Solution {
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) return;
                
        for (int i = 0; i < board[0].length; i++){
            if (board[0][i] == 'O'){
                board[0][i] = '*';
                dfs(board, 0, i);
            }
            if (board[board.length-1][i] == 'O'){
                board[board.length-1][i] = '*';
                dfs(board, board.length-1, i);
            }
        }
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == 'O'){
                board[i][0] = '*';
                dfs(board, i, 0);
            }
            if (board[i][board[0].length-1] == 'O'){
                board[i][board[0].length-1] = '*';
                dfs(board, i, board[0].length-1);
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
        return;
    }
    private void dfs(char[][] board, int i, int j){
        if (i-1>0 && board[i-1][j]=='O'){
            board[i-1][j] = '*';
            dfs(board, i-1, j);
        }
        if (j-1>0 && board[i][j-1]=='O'){
            board[i][j-1] = '*';
            dfs(board, i, j-1);
        }
        if (i+1<board.length-1 && board[i+1][j]=='O'){
            board[i+1][j] = '*';
            dfs(board, i+1, j);
        }
        if (j+1<board[0].length-1 && board[i][j+1]=='O'){
            board[i][j+1] = '*';
            dfs(board, i, j+1);
        }
    }
    
}