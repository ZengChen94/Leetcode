//http://blog.csdn.net/zjucor/article/details/73719072

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>(){  
            @Override  
            public int compare(int[] a, int[] b) {  
                return a[1] - b[1]; // ����ٰ���Ĭ�ϵ�һλ����  
            }  
        });  
          
        // ������duration���ڶ��ˣ���������һ���γ̷Ų���ʱ�Ͱ�����duration����  
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>(){  
            @Override  
            public int compare(Integer o1, Integer o2) {  
                return o2 - o1;  
            }  
        });  
          
        int time = 0;  
        for(int[] c : courses) {  
            // �ܲ��pq�Ͳ壬���ܾ;�����pqŪ���յ�  
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