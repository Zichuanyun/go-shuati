class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 31; i >= 0; --i) {
            int digit = 0;
            for(int num : nums) {
                digit += (num >> i) & 1;
                digit %= 3;
            }
            res <<= 1;
            res |= digit;
        }
        return res;
    }
}