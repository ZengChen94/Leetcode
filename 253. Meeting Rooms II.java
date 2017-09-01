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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        int[] starter = new int[intervals.length];
        int[] ender = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starter[i] = intervals[i].start;
            ender[i] = intervals[i].end;
        }
        Arrays.sort(starter);
        Arrays.sort(ender);
        int endPoint = 0;
        int counter = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starter[i] < ender[endPoint]) {
                counter++;
            }
            else {
                endPoint++;
            }
        }
        return counter;
    }
}