class MyCalendar {

    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) 
            return false;
        
        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) 
            return false;

        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

 
// TLE
class MyCalendar {
    LinkedList<int[]> list = new LinkedList<int[]>();
    
    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
        end = end - 1;
        if (list.size() == 0) {
            list.add(new int[]{start, end});
            return true;
        }
        else {
            int last = list.size()-1;
            if (start > list.get(last)[1]) {
                list.add(last+1, new int[]{start, end});
                return true;
            }
            for (int i = 0; i < list.size(); i++) {
                if (start < list.get(i)[0]) {
                    if (end < list.get(i)[0]) {
                        if (end+1 == list.get(i)[0])
                            list.set(i, new int[]{start, list.get(i)[1]});
                        else 
                            list.add(i, new int[]{start, end});
                        if (i > 0) {
                            if (list.get(i-1)[1] == start-1) {
                                list.add(i, new int[]{list.get(i-1)[0], end});
                                list.remove(i-1);
                            }
                        }
                        return true;
                    }
                    else 
                        return false;
                }
                else if (start > list.get(i)[1]) 
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */