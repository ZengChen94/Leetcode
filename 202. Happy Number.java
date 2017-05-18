public class Solution {
    public boolean isHappy(int n) {
        int slow, fast;
        
        //the way of #Linked List Cycle detection problem
        //so when facing loop, this way can always work
        slow = digitSquareSum(n);
        fast = digitSquareSum(n);
        fast = digitSquareSum(fast);
        while(slow != fast && slow != 1){
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } 
        
        return slow == 1;
    }
    
    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}


public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = digitSquareSum(n);
        }

        return n == 1;
    }
    
    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}