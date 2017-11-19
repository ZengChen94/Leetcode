class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = left; i <= right; i++) {
            if (helper(i))
                result.add(i);
        }
        return result;
    }
    
    public boolean helper(int num) {
        int i = 1;
        while (i * 10 <= num)
            i = i * 10;
        int num_copy = num;
        while (i != 0) {
            int tmp = num_copy / i;
            if (tmp == 0)
                return false;
            if (num % tmp != 0)
                return false;
            num_copy = num_copy % i;
            i = i / 10;
        }
        return true;
    }
}