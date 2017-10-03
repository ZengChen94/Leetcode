public class Solution {
    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        if (heights.length < 3 || heights[0].length < 3)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    result += Math.max(0, cell.height - heights[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));//here is important
                }
            }
        }
        
        return result;
    }
}

/*
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 3 || heightMap[0].length < 3)
            return 0;
        int[][] minMap = new int[heightMap.length][heightMap[0].length];
        int[][] visit = new int[heightMap.length][heightMap[0].length];
        for (int i = 1; i < heightMap.length-1; i++) {
            int max = heightMap[i][0];
            for (int j = 1; j < heightMap[0].length-1; j++) {
                max = Math.max(max, heightMap[i][j]);
                minMap[i][j] = max;
            }
        }
        for (int i = 1; i < heightMap.length-1; i++) {
            int max = heightMap[i][heightMap[0].length-1];
            for (int j = heightMap[0].length-2; j > 0; j--) {
                max = Math.max(max, heightMap[i][j]);
                minMap[i][j] = Math.min(minMap[i][j], max);
            }
        }
        for (int j = 1; j < heightMap[0].length-1; j++) {
            int max = heightMap[0][j];
            for (int i = 0; i < heightMap.length-1; i++) {
                max = Math.max(max, heightMap[i][j]);
                minMap[i][j] = Math.min(minMap[i][j], max);
            }
        }
        for (int j = 1; j < heightMap[0].length-1; j++) {
            int max = heightMap[heightMap.length-1][j];
            for (int i = heightMap.length-2; i > 0; i--) {
                max = Math.max(max, heightMap[i][j]);
                minMap[i][j] = Math.min(minMap[i][j], max);
            }
        }
        
        for (int i = 1; i < heightMap.length-1; i++) {
            for (int j = 1; j < heightMap[0].length-1; j++) {
                if (minMap[i][j] != 0 && visit[i][j] == 0) {
                    int min = findMin(minMap, visit, i, j, minMap[i][j]);
                    setMin(minMap, visit, i, j, min);
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i < heightMap.length-1; i++) {
            for (int j = 1; j < heightMap[0].length-1; j++) {
                if (minMap[i][j] != 0)
                    cnt += minMap[i][j] - heightMap[i][j];
            }
        }
        
        return cnt;
    }
    
    int findMin(int[][] map, int[][]visit, int i, int j, int min) {
        if (i == 0 || i == map.length-1 || j == 0 || j == map[0].length-1 || visit[i][j] == 1 || map[i][j] == 0)
            return Integer.MAX_VALUE;
        visit[i][j] = 1;
        min = Math.min(min, findMin(map, visit, i+1, j, min));
        min = Math.min(min, findMin(map, visit, i-1, j, min));
        min = Math.min(min, findMin(map, visit, i, j+1, min));
        min = Math.min(min, findMin(map, visit, i, j-1, min));
        return min;
    }
    
    void setMin(int[][] map, int[][]visit, int i, int j, int min) {
        if (i == 0 || i == map.length-1 || j == 0 || j == map[0].length-1 || visit[i][j] == 2 || map[i][j] == 0)
            return;
        visit[i][j] = 2;
        map[i][j] = min;
        setMin(map, visit, i+1, j, min);
        setMin(map, visit, i-1, j, min);
        setMin(map, visit, i, j+1, min);
        setMin(map, visit, i, j-1, min);
        return;
    }
}
*/