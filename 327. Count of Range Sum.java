Class Solution{
	public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;
        int cnt = 0;
        List<Long> list = new LinkedList<Long>();
        long[] nums2 = new long[nums.length];
        nums2[0] = (long)nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums2[i] = nums2[i-1] + (long)nums[i];
        }
        list.add((long)0);
        for (int i = 0; i < nums.length; i++) {
            long lower2 = nums2[i] - (long)upper;
            long upper2 = nums2[i] - (long)lower;
			//binary search in sorted previous result
            cnt += search(list, lower2, upper2);
			//binary add in sorted previous result
            merge(list, nums2[i]);
        }
        return cnt;
    }
    
    public int search(List<Long> list, long lower2, long upper2) {
        int begin = 0; 
        int end = list.size() - 1;
        int tmp1 = 0, tmp2 = 0;
        
        if (lower2 > list.get(list.size()-1) || upper2 < list.get(0))
            return 0;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (list.get(mid) >= lower2) {
                tmp1 = mid;
                end = mid - 1;
            } 
            else if(list.get(mid) < lower2) {
                begin = mid + 1;
            }
        }
        begin = 0;
        end = list.size() - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (list.get(mid) > upper2) {
                end = mid - 1;
            } 
            else if(list.get(mid) <= upper2) {
                tmp2 = mid;
                begin = mid + 1;
            }
        }
        return tmp2 - tmp1 + 1;
    } 
    
    public void merge(List<Long> list, long num) {
        int begin = 0;
        int end = list.size() - 1;
        if (num >= list.get(list.size()-1)){
            list.add(num);
            return;
        }
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (num > list.get(mid)) {
                begin = mid + 1;
            }
            else if (num < list.get(mid)) {
                end = mid - 1;
            }
            else {
                list.add(mid, num);
                return;
            }
        }
        list.add(begin, num);
        return;
    }
}

//maybe can also use sortedTree, when it comes to range