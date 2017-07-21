//http://blog.csdn.net/zjucor/article/details/73719072

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>(){  
            @Override  
            public int compare(int[] a, int[] b) {  
                return a[1] - b[1]; // 相等再按照默认第一位排序  
            }  
        });  
          
        // 把最大的duration放在顶端，这样当来一个课程放不下时就把最大的duration弹出  
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>(){  
            @Override  
            public int compare(Integer o1, Integer o2) {  
                return o2 - o1;  
            }  
        });  
          
        int time = 0;  
        for(int[] c : courses) {  
            // 能插进pq就插，不能就尽量把pq弄紧凑点  
            if(time + c[0] <= c[1]) {  
                pq.add(c[0]);  
                time += c[0];  
            } 
            else if(!pq.isEmpty() && pq.peek() > c[0]) {  
                time += c[0] - pq.poll();  
                pq.add(c[0]);  
            }  
        }  
          
        return pq.size();  
    }
}