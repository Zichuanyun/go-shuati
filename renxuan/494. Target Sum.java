class Solution {
    int res = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S, 0, true);
        dfs(nums, 0, S, 0, false);
        return res/2;
    }
    
    private void dfs(int[] nums, int sum, int S, int start, boolean add) {
        if(start == nums.length) {
            if(sum == S)
                ++res;
            return;
        }
        if(add) sum += nums[start];
        else sum -= nums[start];
        dfs(nums, sum, S, start + 1, true); 
        dfs(nums, sum, S, start + 1, false); 
    }
}
