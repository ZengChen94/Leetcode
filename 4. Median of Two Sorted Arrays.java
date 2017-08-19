public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double median = 0;
        if ((len1+len2)%2 == 1)
        	median = kthNum((len1+len2)/2 + 1, nums1, 0, nums2, 0);    	
        else{
        	median += kthNum((len1+len2)/2, nums1, 0, nums2, 0); 
        	median += kthNum((len1+len2)/2 + 1, nums1, 0, nums2, 0);
        	median = median/2;
        }	
        return median;
    }
    
    int kthNum(int k, int[] nums1, int m, int[] nums2, int n){
    	int len1 = nums1.length - m;
        int len2 = nums2.length - n;
        if (len1 > len2) 
        	return kthNum(k, nums2, n, nums1, m);
        if (len1 == 0)
        	return nums2[n+k-1];
        if (k == 1)
        	return Math.min(nums1[m], nums2[n]);
        
        int point1 = Math.min(len1, k/2);
        int point2 = k - point1;
        
        if (nums1[m+point1-1] < nums2[n+point2-1])
        	return kthNum(k-point1, nums1, m+point1, nums2, n);
        else if (nums1[m+point1-1] > nums2[n+point2-1])
        	return kthNum(k-point2, nums1, m, nums2, n+point2);
        else 
        	return nums1[point1+m-1];
        	
    }
}