public class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                int j = i;
                while (j + 1 < charArray.length && charArray[j + 1] != ' ')
                    j++;
                reverse(charArray, i, j);
                i = j;
            }
        }
        return new String(charArray);
    }

    private void reverse(char[] charArray, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
        }
    }
}