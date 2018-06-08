class Solution {
    public int rob(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int len = nums.length;
        int[] pickLast = new int[len + 1];
        int[] non_pickLast = new int[len + 1];
        non_pickLast[1] = nums[0];
        
        for (int i = 2; i < len; ++i) {
            pickLast[i] = Math.max(pickLast[i - 1], pickLast[i - 2] + nums[i - 1]);
            non_pickLast[i] = Math.max(non_pickLast[i - 1], non_pickLast[i - 2] + nums[i - 1]);
        }
        
        pickLast[len] = Math.max(pickLast[len - 1], pickLast[len - 2] + nums[len - 1]);
        non_pickLast[len] = Math.max(non_pickLast[len - 1], non_pickLast[len - 2]);
        
        return Math.max(non_pickLast[len], pickLast[len]);
    }
}