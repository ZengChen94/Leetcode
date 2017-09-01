//用两个一维数组来做，分别保存起始时间和结束时间，然后各自排个序
//我们定义结果变量res和结束时间指针endpos
//然后我们开始遍历，如果当前起始时间小于结束时间指针的时间，则结果自增1
//反之结束时间指针自增1，这样我们可以找出重叠的时间段，从而安排新的会议室

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