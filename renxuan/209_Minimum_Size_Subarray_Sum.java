class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int end = 0, begin = 0, sum = 0, res = Integer.MAX_VALUE;
        while(end < nums.length) {
            if(sum < s) {
                sum += nums[end++];
            }
            while(begin < end && sum >= s) {
                res = Math.min(res, end - begin);
                sum -= nums[begin++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
