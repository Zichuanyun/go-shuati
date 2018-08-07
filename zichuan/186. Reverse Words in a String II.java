class Solution {
    public void reverseWords(char[] str) {
        reverseSlice(str, 0, str.length - 1);
        for (int tail = 0, head = 0; tail <= str.length; ++tail) {
            if (tail == str.length || str[tail] == ' ') {
                reverseSlice(str, head, tail - 1);
                head = tail + 1;
            }
        }
    }
    
    private void reverseSlice(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            ++start;
            --end;
        }
    }
}