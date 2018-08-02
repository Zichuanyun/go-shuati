class Solution {
    public boolean canJump(int[] nums) {
        int begin = 0, end = 0, maxEnd = 0, n = nums.length;
        while(true) {
            for(int i = begin; i <= end; ++i) {
                maxEnd = Math.max(maxEnd, i + nums[i]);
                if(maxEnd >= n - 1) return true;
            }
            if(maxEnd == end) return false;
            begin = end + 1;
            end = maxEnd;
        }
    }
}
