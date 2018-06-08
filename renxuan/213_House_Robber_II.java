class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robi(nums, 0, nums.length-2), robi(nums, 1, nums.length-1));
    }
    
    private int robi(int[] nums, int start, int end) {
        int noRob = 0, rob = 0;
        for(int i = start; i <= end; ++i) {
            int oldNoRob = noRob;
            noRob = Math.max(noRob, rob);
            rob = oldNoRob + nums[i];
        }
        return Math.max(noRob, rob);
    }
}