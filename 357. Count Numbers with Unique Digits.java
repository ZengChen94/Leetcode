class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if (n > 10) return 0;
        if (n == 0) return 1;
        int cnt = 10;
        int tmp = 9;
        int tmp2 = 9;
        while (--n != 0) {
            tmp = tmp * tmp2;
            cnt += tmp;
            tmp2 -= 1;
        }
        return cnt;
    }
};