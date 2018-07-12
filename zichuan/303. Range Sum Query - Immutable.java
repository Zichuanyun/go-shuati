class NumArray {

    int[] dp;
    
    public NumArray(int[] nums) {
        //corner case
        //if(nums == null || nums.length == 0) return;
        dp = new int[nums.length + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}