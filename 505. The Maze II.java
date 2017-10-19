//Dijksra
//Anyway, I don't think this is Dijksra. It's just bfs, using PriorityQueue.
public class Solution {
	int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // base case
        if(Arrays.equals(start, destination)) return 0;
        m = maze.length; n = maze[0].length;
        return shortestPath(maze, start, destination);
    }
    
    private int shortestPath(int[][] maze, int[] start, int[] destination) {
        // get the vertice has the minimum distance to start
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        minHeap.offer(new Node(start[0], start[1], 0));
        
        // map that contains information of node: distance to start point
        int[][] visited = new int[m][n];
        for(int[] arr : visited) Arrays.fill(arr, Integer.MAX_VALUE);
        
        while(!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            // find the shortest path
            if(cur.x == destination[0] && cur.y == destination[1]) return cur.distance;
            
            for(int[] dir : dirs) {
                int nx = cur.x, ny = cur.y;
                while(isInMaze(nx + dir[0], ny + dir[1]) && maze[nx + dir[0]][ny + dir[1]] != 1) {
                    nx += dir[0];  ny += dir[1];
                }
                int distance = cur.distance + Math.abs(nx - cur.x) + Math.abs(ny - cur.y);
                if(visited[nx][ny] > distance) {
                    minHeap.offer(new Node(nx, ny, distance));
                    visited[nx][ny] = distance;
                }
            }
        }
        return -1;
    }
    
    private boolean isInMaze(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    class Node {
        int x;
        int y;
        // distance to start point
        int distance;
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

// dfs
class Solution {
public:
    vector<vector<int>> dirs{{0,-1},{-1,0},{0,1},{1,0}};
    int shortestDistance(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size(), n = maze[0].size();
        vector<vector<int>> dists(m, vector<int>(n, INT_MAX));
        dists[start[0]][start[1]] = 0;
        helper(maze, start[0], start[1], destination, dists);
        int res = dists[destination[0]][destination[1]];
        return (res == INT_MAX) ? -1 : res;
    }
    void helper(vector<vector<int>>& maze, int i, int j, vector<int>& destination, vector<vector<int>>& dists) {
        if (i == destination[0] && j == destination[1]) return;
        int m = maze.size(), n = maze[0].size();
        for (auto d : dirs) {
            int x = i, y = j, dist = dists[x][y];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += d[0];
                y += d[1];
                ++dist;
            }
            x -= d[0];
            y -= d[1];
            --dist;
            if (dists[x][y] > dist) {
                dists[x][y] = dist;
                helper(maze, x, y, destination, dists);
            }
        }
    }
};