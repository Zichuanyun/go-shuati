class Solution {
    public int maxCoins(int[] nums) {
        int[] newnums = new int[nums.length + 2];
        int n = 1;
        for(int x: nums) if(x > 0) newnums[n++] = x;
        newnums[0] = newnums[n++] = 1;
        
        int[][] memo = new int[n][n];
        return burst(memo, newnums, 0, n-1);
    }
    public int burst(int[][] memo, int[] nums, int left, int right) {
        if(left + 1 == right) return 0;
        if(memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}