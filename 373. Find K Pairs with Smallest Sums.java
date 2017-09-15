public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) 
            return result;
        for(int i = 0; i < nums1.length && i < k; i++) 
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !queue.isEmpty()){
            int[] cur = queue.poll();
            result.add(new int[]{cur[0], cur[1]});
            
            if(cur[2] == nums2.length-1) 
                continue;
            queue.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return result;
    }
}

//This won't work and will have many duplicate!
//We need to fix one index at first, eg, push every index of nums1 with 0 of nums2 at first, and then change the nums2
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<int[]>();
        //index1, index2
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a1, a2) -> (nums1[a1[0]]+nums2[a1[1]]-nums1[a2[0]]-nums2[a2[1]]));
        if (k == 0 || nums1.length == 0 || nums2.length == 0)
            return result;
        queue.offer(new int[]{0, 0});
        while (k != 0) {
            int[] index = queue.poll();
            result.add(new int[]{nums1[index[0]], nums2[index[1]]});
            if (index[0]+1 < nums1.length)
                queue.offer(new int[]{index[0]+1, index[1]});
            if (index[1]+1 < nums2.length)
                queue.offer(new int[]{index[0], index[1]+1});
            k = k-1;
            if (result.size() == nums1.length*nums2.length)
                break;
        }
        return result;
    }
}