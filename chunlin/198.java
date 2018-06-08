class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] opt = new int[nums.length + 1];
        opt[0] = 0;
        opt[1] = Math.max(opt[0], nums[0]);
        for (int i = 1; i < nums.length; i++) {
            opt[i + 1] = Math.max(opt[i], opt[i - 1] + nums[i]);    // nums[i] -> the i+1 th house, starting from 1st
        }
        return opt[nums.length];
    }
}
