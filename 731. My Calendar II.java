class MyCalendarTwo {

    List<int[]> calendar;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        TreeMap<Integer, Integer> overlaps = new TreeMap<>();

        for (int[] interval : calendar) {
            int[] overlap = getOverlap(interval, start, end);
            if (overlap[0] >= 0) {
                if (hasOverlap(overlaps, overlap[0], overlap[1])) return false;
                overlaps.put(overlap[0], overlap[1]);
            }
        }

        calendar.add(new int[] {start, end});
        return true;
    }

    private int[] getOverlap(int[] interval, int start, int end) {
        int[] res = new int[] {-1, -1};
        if (start >= interval[1] || end <= interval[0]) return res;
        res[0] = Math.max(start, interval[0]);
        res[1] = Math.min(end, interval[1]);
        return res;
    }

    private boolean hasOverlap(TreeMap<Integer, Integer> overlaps, int start, int end) {
        Integer floorKey = overlaps.floorKey(start);
        if (floorKey != null && overlaps.get(floorKey) > start) return true;
        Integer ceilingKey = overlaps.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return true;
        return false;
    }

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */