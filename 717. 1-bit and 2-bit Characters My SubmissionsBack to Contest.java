class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int tmp = 0;
        for (int i = 0; i < bits.length; ) {
            if (bits[i] == 0) {
                tmp = 1;
                i+=1;
            }
            else {
                tmp = 2;
                i+=2;
            }
        }
        return tmp == 1;
    }
}