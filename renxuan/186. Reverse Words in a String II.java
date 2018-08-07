public class Solution {
    public char[] reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int index = 0;
        for(int i = 0; i < str.length; ++i) {
            if(str[i] == ' ') {
                reverse(str, index, i - 1);
                index = i + 1;
            }
        }
        reverse(str, index, str.length - 1);
        return str;
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char tmp = str[start];
            str[start++] = str[end];
            str[end--] = tmp;
        }
    }
}
