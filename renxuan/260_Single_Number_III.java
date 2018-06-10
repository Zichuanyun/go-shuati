class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        int lastOne = 1;
        while((xor & lastOne) == 0) lastOne <<= 1;
        int first = 0;
        for(int num : nums) {
            if((num & lastOne) != 0)
                first ^= num;
        }
        int second = xor ^ first;
        return new int[]{first, second};
    }
}