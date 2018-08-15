class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, maxContainsPrev = Integer.MIN_VALUE;
        for(int num : nums) {
            maxContainsPrev = num + Math.max(0, maxContainsPrev);
            res = Math.max(res, maxContainsPrev);
        }
        return res;
    }
}
