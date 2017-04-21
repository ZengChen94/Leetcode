public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1)//Always remember to cut special situations (pay attention to 0)
			return s;
        String result = new String();
		for (int i = 1; i <= numRows; i++){
			if (i == 1){
				int j = 0;
				while (1+2*(numRows-1)*j <= s.length()){
					//1+2*(numRows-1)*j
					result = result + s.charAt(1+2*(numRows-1)*j-1);
					j+=1;
				}
			}
			else if(i == numRows){
				int j = 0;
				while (numRows+2*(numRows-1)*j <= s.length()){
					//numRows+2*(numRows-1)*j
					result = result + s.charAt(numRows+2*(numRows-1)*j-1);
					j+=1;
				}
			}
			else{
				int j = 0;
				while (i+2*(numRows-1)*j <= s.length() || 2*numRows-i+2*(numRows-1)*j <= s.length()){
					if (i+2*(numRows-1)*j <= s.length()){
						//i+2*(numRows-1)*j
						result = result + s.charAt(i+2*(numRows-1)*j-1);
					}
					if (2*numRows-i+2*(numRows-1)*j <= s.length()){
						//2*numRows-i+2*(numRows-1)*j
						result = result + s.charAt(2*numRows-i+2*(numRows-1)*j-1);
					}
					j+=1;
				}
			}
		}
        return result;
    }
}