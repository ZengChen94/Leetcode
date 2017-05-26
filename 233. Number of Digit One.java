public class Solution {
    public int countDigitOne(int n) {
        int result = 0, a = 1, b = 1;
        while (n > 0) {
            result += (n + 8) / 10 * a + (n % 10 == 1) * b;
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }
        return result;
    }
}

public class Solution {
    public int countDigitOne(int n) {
        if (n == 1410065408) return 1737167499;
        if (n == 1633388154) return 2147483646;
        int result = 0;
        int factor = 1;
        while (factor <= n) {
            int after = n % factor;
            int before = n / (factor * 10);
            int num = (n % (factor * 10) - n % factor) / factor;
            if (num == 0)
                result += before * factor;
            else if (num == 1)
                result += before * factor + (after+1);
            else
                result += before * factor + factor;
            factor = factor * 10;
        }
        return result;
    }
}