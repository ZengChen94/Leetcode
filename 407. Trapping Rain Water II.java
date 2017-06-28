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