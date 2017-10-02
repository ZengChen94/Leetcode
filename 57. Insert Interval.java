/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0; i < intervals.size(); ) {
            if (newInterval.end < intervals.get(i).start) {
                intervals.add(i, newInterval);
                return intervals;
            }
            else if (newInterval.start > intervals.get(i).end) {
                i++;
            }
            else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                intervals.remove(i);
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}