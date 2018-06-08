class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(helper(0, n - 2, nums), helper(1, n - 1, nums));
    }
    public int helper(int lo, int hi, int[] nums) {
        int[] opt = new int[hi - lo + 2];
        opt[0] = 0;
        opt[1] = nums[lo];
        for (int i = 2; i <= hi - lo + 1; i++) {
            opt[i] = Math.max(opt[i - 1], opt[i - 2] + nums[lo + i - 1]);
        }
        return opt[hi - lo + 1];
    }
}
