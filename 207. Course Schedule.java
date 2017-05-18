public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int m = prerequisites[i][0];
            int n = prerequisites[i][1];
            if (matrix[n][m] == 0)
                indegree[m]++;
            matrix[n][m] = 1;//n-->m
            
        }
        
        int cnt = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            cnt++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[tmp][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0)
                        queue.add(i);
                }
            }
        }
        
        return cnt == numCourses;
    }
}