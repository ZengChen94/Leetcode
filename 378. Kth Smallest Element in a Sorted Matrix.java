public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }
    
    private int getLessEqual(int[][] matrix, int val) {
        int result = 0;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] > val) 
                i--;
            else {
                result += i + 1;
                j++;
            }
        }
        return result;
    }
}

//This method is similar to 373. Find K Pairs with Smallest Sums
//I prefer this method, using PriorityQueue
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}