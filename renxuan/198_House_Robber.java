class Solution {
    public int rob(int[] nums) {
        int noRob = 0, rob = 0;
        for(int i = 0; i < nums.length; ++i) {
            int oldNoRob = noRob;
            noRob = Math.max(noRob, rob);
            rob = oldNoRob + nums[i];
        }
        return Math.max(noRob, rob);
    }
}