public class ZigzagIterator {  
    List<Iterator<Integer>> iters = new ArrayList<Iterator<Integer> >();   
      
    int count = 0;  
  
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {  
        if(!v1.isEmpty()) 
			iters.add(v1.iterator());  
        if(!v2.isEmpty()) 
			iters.add(v2.iterator());  
    }  
  
    public int next() {  
        int x = iters.get(count).next();  
        if(!iters.get(count).hasNext()) 
			iters.remove(count);  
        else 
			count++;  
          
        if(iters.size() != 0) 
			count %= iters.size();  
        return x;  
    }  
  
    public boolean hasNext() {  
        return !iters.isEmpty();  
    }  
}  
  
/** 
 * Your ZigzagIterator object will be instantiated and called as such: 
 * ZigzagIterator i = new ZigzagIterator(v1, v2); 
 * while (i.hasNext()) v[f()] = i.next(); 
 */  

