public class Solution {
    public int cnt = 0;
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        dfs(board, 0);
        return cnt;
    }
    
    public void dfs(char[][] board, int col) {
        if (col == board.length) {
            cnt += 1;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[i][col] = 'Q';
            if (valid(board, i, col))
                dfs(board, col+1);
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
}

public class Solution {
	public int totalNQueens(int n) {  
        int[] res = {0};
        if(n<=0)
            return res[0];
            
        int [] columnVal = new int[n];
        
        DFS_helper(n,res,0,columnVal);
        return res[0];
    }
    
    public void DFS_helper(int nQueens, int[] res, int row, int[] columnVal){
        if(row == nQueens){
            res[0] += 1;
        }else{
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i;//(row,columnVal[row)==>(row,i)
                
                if(isValid(row,columnVal))
                    DFS_helper(nQueens, res, row+1, columnVal);
            }
        }
    }
    
    public boolean isValid(int row, int [] columnVal){
        for(int i = 0; i < row; i++){
            if(columnVal[row] == columnVal[i]
               ||Math.abs(columnVal[row]-columnVal[i]) == row-i)
               return false;
        }
        return true;
	}
}