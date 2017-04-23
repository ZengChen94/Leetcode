public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
    
        int result = 0;
        int start = 0, end = height.length - 1;
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        leftMax[0] = 0;
        int tmpMax = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = tmpMax;
            tmpMax = height[i] > tmpMax? height[i] : tmpMax;
        }
        
        rightMax[0] = 0;
        tmpMax = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = tmpMax;
            tmpMax = height[i] > tmpMax? height[i] : tmpMax;
        }
        
        for (int i = 0; i < height.length; i++) {
            tmpMax = Math.min(leftMax[i], rightMax[i]);
            if (tmpMax > height[i])
                result += tmpMax - height[i];
        }
        
        return result;
    }
}