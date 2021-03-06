/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 // Collections.sort
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> timeLine = new ArrayList<>();
        schedule.forEach(e -> timeLine.addAll(e));
        Collections.sort(timeLine, ((a, b) -> a.start - b.start));
        
        List<Interval> result = new ArrayList<>();
        Interval temp = timeLine.get(0);
        
        for(Interval each : timeLine) {
            if(temp.end < each.start) {
                result.add(new Interval(temp.end, each.start));
                temp = each;
            }else{
                temp = temp.end < each.end ? each : temp;
            }
        }
        return result;
    }
}

// PriorityQueue
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(e -> pq.addAll(e));

        Interval temp = pq.poll();
        while(!pq.isEmpty()) {
            if(temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            }else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }
}