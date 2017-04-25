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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) return result;
        
        for (int i = 0; i < intervals.size(); i++){
            insertInterval(result, intervals.get(i));
        }
        
        return result;
    }
    
    private void insertInterval(List<Interval> result, Interval insertedInterval){
        for (int i = 0; i < result.size(); ){
            if (insertedInterval.end < result.get(i).start) {//add 
                result.add(i, insertedInterval);
                return;
            }
            else if (insertedInterval.start > result.get(i).end){
                i++;
                continue;
            }
            else {
                insertedInterval.start = Math.min(insertedInterval.start, result.get(i).start);
                insertedInterval.end = Math.max(insertedInterval.end, result.get(i).end);
                result.remove(i);
            }
        }
        
        if (result.size() == 0) {
            result.add(insertedInterval);
            return;
        }
        if (insertedInterval.start > result.get(result.size()-1).end){//add in the end
    		result.add(insertedInterval);
    		return;
    	}
    	
        return;
    }
}