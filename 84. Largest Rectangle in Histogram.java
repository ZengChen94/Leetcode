public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        if (heights.length == 0) return 0;
        int[] newHeights = new int[heights.length+1];
        newHeights[0] = 0;
        for (int i = 0; i < heights.length; i++)
            newHeights[i+1] = heights[i];
        heights = newHeights;
        
        for (int i = 0; i < heights.length; i++){
            if (stack.empty()) stack.push(i);
            else if (heights[i] >= heights[stack.peek()]) 
                stack.push(i);
            else{
                while(heights[i] < heights[stack.peek()]){
                    int curIndex = stack.pop();
                    max = max > (i-stack.peek()-1)*heights[curIndex]? max : (i-stack.peek()-1)*heights[curIndex];
                }
                stack.push(i);
            }
        }
        if (!stack.empty()){
            int maxIndex = stack.peek();
            int preIndex = stack.pop();
            if (!stack.empty()){
                while (!stack.empty()){
                    int curIndex = preIndex;
                    preIndex = stack.pop();
                    max = max > (maxIndex-preIndex)*heights[curIndex]? max : (maxIndex-preIndex)*heights[curIndex];
                }
                max = max > (maxIndex-preIndex+1)*heights[preIndex] ? max : (maxIndex-preIndex+1)*heights[preIndex];
            }
            else
                max = max > heights[maxIndex] ? max : heights[maxIndex];
        }
        return max;
    }
}