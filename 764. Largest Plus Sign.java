class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // store number of 1s before/after current position (self included)
        // initialize
        int[][] horizontal = new int[N][N];
        int[][] vertical = new int[N][N];
        int[][] revhorizontal = new int[N][N];
        int[][] revvertical = new int[N][N];
        for (int[] zero : mines) {
            horizontal[zero[0]][zero[1]] = -1;
            vertical[zero[0]][zero[1]] = -1;
            revhorizontal[zero[0]][zero[1]] = -1;
            revvertical[zero[0]][zero[1]] = -1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vertical[i][j] == -1) {
                    horizontal[i][j] = 0;
                    vertical[i][j] = 0;
                } else {
                    horizontal[i][j] = (j == 0) ? 1 : horizontal[i][j - 1] + 1;
                    vertical[i][j] = (i == 0) ? 1 : vertical[i - 1][j] + 1;
                }
                int revi = N - 1 - i, revj = N - 1 - j;
                if (revvertical[revi][revj] == -1) {
                    revhorizontal[revi][revj] = 0;
                    revvertical[revi][revj] = 0;
                } else {
                    revhorizontal[revi][revj] = (revj == N - 1) ? 1 : revhorizontal[revi][revj + 1] + 1;
                    revvertical[revi][revj] = (revi == N - 1) ? 1 : revvertical[revi + 1][revj] + 1;
                }
            }
        }
        // traverse
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vertical[i][j] != 0) {
                    int up = vertical[i][j];
                    int down = revvertical[i][j];
                    int left = horizontal[i][j];
                    int right = revhorizontal[i][j];
                    int current = Math.min(Math.min(up, down), Math.min(left, right));
                    count = Math.max(count, current);
                }
            }
        }
        return count;
    }
}