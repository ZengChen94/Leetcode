class Solution {
    public int[][] candyCrush(int[][] board) {
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new MyComp());
		while (stable(board, queue)) {
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				int i = cur[0];
				int j = cur[1];
				while (i > 0 && board[i][j] != 0) {
					board[i][j] = board[i - 1][j];
					i--;
				}
				board[i][j] = 0;
			}
		}

		return board;
	}

	public boolean stable(int[][] board, PriorityQueue<int[]> queue) {
		boolean isunstable = false;
		boolean[][] visited = new boolean[board.length][board[0].length];
// For Horizontal matches
		for (int i = 0; i < board.length; i++) {
			int j = 0;
			while (j < board[0].length) {
				if(board[i][j]==0){
					j++;
					continue;
				}
				int count = 1;
				while (j < board[0].length - 1 && board[i][j] == board[i][j + 1]) {
					count++;
					j++;
				}
				if (count >= 3) {
					isunstable = true;
					int k = j - count + 1;
					while (k <= j) {
						if (!visited[i][k]) {
							queue.offer(new int[] { i, k });
							visited[i][k] = true;
						}
						k++;
					}
				}
				j++;
			}
		}
//For Vertical Matches
		for (int j = 0; j < board[0].length; j++) {
			int i = 0;
			while (i < board.length) {
				if(board[i][j]==0){
					i++;
					continue;
				}
				int count = 1;
				while (i < board.length - 1 && board[i][j] == board[i + 1][j]) {
					count++;
					i++;
				}
				if (count >= 3) {
					isunstable = true;
					int k = i - count + 1;
					while (k <= i) {
						if (!visited[k][j]) {
							queue.offer(new int[] { k, j });
							visited[k][j] = true;
						}
						k++;
					}
				}
				i++;
			}
		}
		return isunstable;
	}
    
    class MyComp implements Comparator<int[]> {
        public int compare(int[] i1, int[] i2) {
            return i1[0] - i2[0];
        }
    }
}