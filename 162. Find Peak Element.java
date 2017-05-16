public class Solution {
    //If num[i-1] < num[i] > num[i+1], then num[i] is peak
    //If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
    //If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
    //If num[i-1] > num[i] < num[i+1], then both sides have peak
    public int findPeakElement(int[] num) {
        return helper(num, 0, num.length-1);
    }

    
    public int helper(int[] num, int start, int end){
        if(start == end){
            return start;
        }
        else if(start+1 == end){
            return num[start] > num[end]? start : end;
        }
        else{
            int mid = (start + end) / 2;
            if(num[mid] > num[mid-1] && num[mid] > num[mid+1]){
                return mid;
            }
            else if(num[mid-1] > num[mid] && num[mid] > num[mid+1]){
                return helper(num, start, mid-1);
            }
            else{
                return helper(num, mid+1, end);
            }
        }
    }
}