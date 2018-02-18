/*
Now, say 13 rabbits answer 5. What does this imply? 
Say one of the rabbits is red. We could have 5 other red rabbits in this group answering 5, but not more. 
So, say another rabbit in this group is a different color (blue). 
We could have 5 other blue rabbits in this group answering 5, but not more. 
Finally, another rabbit must be a different color (green), and there are 5 other green rabbits (in the forest).
*/

class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;

        int ans = 0;
        for (int k = 0; k < 1000; ++k)
            ans += Math.floorMod(-count[k], k+1) + count[k];
        return ans;
    }
}