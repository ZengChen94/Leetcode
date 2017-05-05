public class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];        
        int sum = 0;
        Arrays.fill(candies, 1);
        //from left to right
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        //from right to left
        for (int i = ratings.length-2; i>=0; i--){
            if (ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1]+1);
        }
        for (int i = 0; i < ratings.length; i++)
            sum += candies[i];
        return sum;
    }
}