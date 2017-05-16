public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        String result = "";
        
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            result = '-' + result;
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        result += num / den;
        num %= den;
        if (num == 0)
            return result;
        
        result += '.';
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        map.put(num, result.length());
        while (num != 0) {
            num *= 10;
            result += num / den;
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                result = result.substring(0, index) + "(" + result.substring(index, result.length());
                result += ")";
                break;
            }
            else {
                map.put(num, result.length());
            }
        }
        
        return result;
    }
}