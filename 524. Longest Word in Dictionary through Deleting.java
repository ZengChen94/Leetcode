public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
		//here in fact we can sort the dict according from long to short
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) 
                if (i < dictWord.length() && c == dictWord.charAt(i)) 
                    i++;

            if (i == dictWord.length() && dictWord.length() >= longest.length()) 
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }
}