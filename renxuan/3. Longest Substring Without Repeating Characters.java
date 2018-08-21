class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] dict = new int[128];
        char[] array = s.toCharArray();
        int end = 0, begin = 0, max = 0;
        while(end < array.length) {
            while(end < array.length && dict[array[end]]++ == 0) ++end;
            max = Math.max(max, end - begin);
            if(end == array.length) break;
            while(begin <= end && --dict[array[begin++]] != 1);
            ++end;
        }
        return max;
    }
}
