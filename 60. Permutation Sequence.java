public class Solution {
    public String getPermutation(int n, int k) {
        int copy_n = n;
        String result = new String();
        boolean[] visit = new boolean[copy_n];
        while (n != 1){
            int step = 1;
            for (int i = 1; i < n; i++)
                step = step * i;
            int now = k / step;
            if (k % step != 0)
                now = now + 1;
            k = k - (now-1)*step;
            n = n - 1;
            for (int i = 0; i < copy_n; i++){
                if (visit[i] == true)
                    continue;
                else
                    now--;
                if (now == 0){
                    visit[i] = true;
                    result = result + Integer.toString(i+1);
                    break;
                }
            }
        }

        for (int i = 0; i < copy_n; i++){//the last element should be added deperately
            if (visit[i] == false){
                result = result + Integer.toString(i+1);
            }
        }
        return result;
    }
}