public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char char1 = secret.charAt(i);
            char char2 = guess.charAt(i);
            if (char1 == char2) 
                bulls++;
            else {
                if (numbers[char1-'0'] < 0) cows++;
                numbers[char1-'0']++;
                if (numbers[char2-'0'] > 0) cows++;
                numbers[char2-'0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}