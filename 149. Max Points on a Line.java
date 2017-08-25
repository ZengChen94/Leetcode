/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 /*
 key, value = slope, number of points
 */
 
public class Solution{
    public int maxPoints(Point[] points) {
    	if (points.length < 3) return points.length;  
          
        int max = 0; 
        Map<Double, Integer> map = new HashMap<Double, Integer>();
          
        for (int i = 0; i < points.length; i++) {//set every points 
            map.clear();  
            int duplicate = 1;//record duplicate!!! 
              
            for(int j = 0 ; j < points.length; j++){//travel
                if (i == j) continue;
                double slope = 0.0;//slope  
                  
                if (points[i].x == points[j].x && points[i].y == points[j].y) {//duplicate
                    duplicate++;  
                    continue;  
                } else if (points[i].x == points[j].x) {//slope = max_limit --> Integer.MAX_VALUE  
                    slope = Integer.MAX_VALUE;  
                } else {//slope
                    slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);  
                }  
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);  
            }  
              
            //update  
            if (map.keySet().size() == 0) {//think of duplicate!!! 
                max = duplicate > max ? duplicate : max;  
            } else {  
                for (double key : map.keySet()) {  
                    max = Math.max((duplicate + map.get(key)), max);   
                }  
            }  
        }  
        return max;  
    }
}