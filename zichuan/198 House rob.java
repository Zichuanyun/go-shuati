class Solution {
    public int rob(int[] nums) {
        // corner case
        if (nums == null) {
            return 0;
        }
        int r0 = 0, r1 = 0;
        for (int i = 0; i < nums.length; ++i) {
            int temp = r1;
            r1 = Math.max(r1, r0 + nums[i]);
            r0 = temp;
        }
        return r1;
    }
}