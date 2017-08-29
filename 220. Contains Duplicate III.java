public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0 || nums == null || nums.length < 2) 
            return false;  
        
        //backed by binary search tree
        SortedSet<Long> set = new TreeSet<Long>();  
          
        for(int j = 0; j < nums.length; j++) { 
			//return part elements of the sorted collection, ranging from fromElement(Included) to toElement(Not included)
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
            
            if(!subSet.isEmpty()) return true;  
              
            if(j >= k) {  
                set.remove((long)nums[j-k]);  
            }  
            set.add((long)nums[j]);  
        }  
        return false;  
    }
}