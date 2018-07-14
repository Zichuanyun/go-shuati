class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = nums[start];
        while(end < nums.length) {
            if(sum >= s) {
                if(start == end) return 1;
                min = Math.min(end - start + 1, min);
                sum -= nums[start];
                start++;
            } else {
                end++;
                if(end < nums.length) {
                    sum += nums[end];
                }
            }
        }
        
        if(min == Integer.MAX_VALUE) return 0;
        else return min;
    }
}