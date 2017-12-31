/*
[Detailed simple example to support explanation by @zshen9]
[case 1] // target = 3
1 + 2 = 3 => sum-target = 3-3 => 'residual' is 0: this step '2' is the answer.

[case 2] // target = 2
1+2 = 3 // sum-target = 3-2 => 'residual' is 1: gone over by odd number => Can do nothing.
1+2+3 = 6 // sum-target = 6-2 => 'residual' is 4: gone over by even number => Flip 2 to add -4 (subtract 2*2)
1-2+3 = 2 // => this step '3' is the answer

[The following condition assures flipping only a number is sufficient.]

Flipping by only a number always has the meaning to subtract even integer.
The 'residual' cannot exceed 2 * (last number added to 'sum') because;
2*1 <= ... <= (even number of residual) < (N-1) + ('N' added to sum at step N) < 2 * N
*/

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int res = 1, sum = 0;
        while (sum < target || (sum - target) % 2 == 1) {
            sum += res;
            res++;
        }
        return res - 1;
    }
}