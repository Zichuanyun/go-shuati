class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int left = -1, right = -1;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) {
                if(left == -1 || left > m)
                    left = m;
            }
            if(nums[m] >= target) {
                r = m - 1;
            }
            else l = m + 1;
        }
        if(left == -1) return new int[]{-1, -1};
        l = 0; r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) {
                if(right == -1 || right < m)
                    right = m;
            }
            if(nums[m] <= target) {
                l = m + 1;
            }
            else r = m - 1;
        }
        return new int[]{left, right};
    }
}