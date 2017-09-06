public class Solution {
    public boolean canWinNim(int n) {
		//always make the remaining to be factor of 4
        return n % 4 != 0;
    }
}