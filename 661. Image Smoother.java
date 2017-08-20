class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int cnt = 0;
                int total = 0;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    total += M[i-1][j-1];
                    cnt += 1;
                } 
                if (i - 1 >= 0) {
                    total += M[i-1][j];
                    cnt += 1;
                }
                if (i - 1 >= 0 && j + 1 < M[0].length) {
                    total += M[i-1][j+1];
                    cnt += 1;
                }
                if (j - 1 >= 0) {
                    total += M[i][j-1];
                    cnt += 1;
                }
                total += M[i][j];
                cnt += 1;
                if (j + 1 < M[0].length) {
                    total += M[i][j+1];
                    cnt += 1;
                }
                if (i + 1 < M.length && j - 1 >= 0) {
                    total += M[i+1][j-1];
                    cnt += 1;
                }
                if (i + 1 < M.length) {
                    total += M[i+1][j];
                    cnt += 1;
                }
                if (i + 1 < M.length && j + 1 < M[0].length) {
                    total += M[i+1][j+1];
                    cnt += 1;
                }
                res[i][j] = total / cnt;
            }
        }
        return res;
    }
}