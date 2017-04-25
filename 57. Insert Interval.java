/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        for (int i = 0; i < intervals.size(); ){
            if (newInterval.end < intervals.get(i).start) {//add 
                intervals.add(i, newInterval);
                return intervals;
            }
            else if (newInterval.start > intervals.get(i).end){
                i++;
                continue;
            }
            else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                intervals.remove(i);
            }
        }
        
        ////the order doesn't matter too much
        //if (intervals.size() == 0) {
        //    intervals.add(newInterval);
        //    return intervals;
        //}
        //if (newInterval.start > intervals.get(intervals.size()-1).end){//add in the end
    	//	intervals.add(newInterval);
    	//	return intervals;
    	//}
    	
    	intervals.add(newInterval);
    	
        return intervals;
    }
    
}