public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Stack <Integer> stack = new Stack <Integer>();
        int[] result = new int[k];
        if (k == 0) return result;
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k-i > nums2.length)
        		continue;
            int[] array1 = maxNumberSingle(nums1, i);
            int[] array2 = maxNumberSingle(nums2, k-i);
            int[] resultTmp = merge(array1, array2);
            result = greater(resultTmp, result);
        }
        return result;
    }
    
    private int[] maxNumberSingle(int[] nums, int k) {
        Stack <Integer> stack = new Stack <Integer>();
        int[] result = new int[k];
        if (k == 0) return result;
        for (int i = 0; i < nums.length; ) {
            while (!stack.isEmpty() && stack.size() + (nums.length-1-i) >= k && stack.peek() < nums[i])
                stack.pop();
            if (stack.size() == k){
            	i++;
            	continue;
            }
            stack.push(nums[i]);
            i++;
        }
        for (int index = k-1; index >= 0; index--) {
            result[index] = stack.pop();
        }
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length+nums2.length];
        int i = 0, j = 0;
        for (; i < nums1.length && j < nums2.length;) {
            int tmpi = i, tmpj = j;
            while (tmpi < nums1.length && tmpj < nums2.length && nums1[tmpi] == nums2[tmpj]) {
                tmpi++;
                tmpj++;
            }
            if (tmpi == nums1.length) {
                result[i+j] = nums2[j];
                j++;
            }
            else if (tmpj == nums2.length) {
                result[i+j] = nums1[i];
                i++;
            }
            else if (nums1[tmpi] > nums2[tmpj]) {
                result[i+j] = nums1[i];
                i++;
            }
            else {
                result[i+j] = nums2[j];
                j++;
            }
        }
        for (; i < nums1.length;) {
            result[i+j] = nums1[i];
            i++;
        }
        for (; j < nums2.length;) {
            result[i+j] = nums2[j];
            j++;
        }
        return result;
    }
    
    private int[] greater(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i])
                return nums1;
            else if(nums1[i] < nums2[i])
                return nums2;
            else
                continue;
        }
        return nums1;
    }
}