/* The read4 API is defined in the parent class Reader4. 
      int read4(char[] buf); */  
  
  
public class Solution extends Reader4 {  
    /** 
     * @param buf Destination buffer 
     * @param n   Maximum number of characters to read 
     * @return    The number of characters read 
     */  
    private Queue<Character> queue = new LinkedList<Character>();//using queue to store rest of characters from the last time
    private boolean endOfFile = false;  
       
    public int read(char[] buf, int n) {  
        if(buf == null || n == 0) return 0;  
          
        while(queue.size() < n && !endOfFile){//read n characters
            char[] localbuf = new char[4];  
            int localNum = read4(localbuf);  
            if(localNum < 4) {  
                endOfFile = true;  
            }  
            for(int i = 0; i < localNum; i++){  
                queue.add(localbuf[i]);  
            }  
        }  
        int size = Math.min(queue.size() , n);  
        for(int i = 0; i < size; i++){  
            buf[i] = queue.poll();  
        }  
        return size;  
    }  
}  