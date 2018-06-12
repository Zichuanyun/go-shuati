class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int i : nums) {
            single = single ^ i;
        }
        return single;
    }
}