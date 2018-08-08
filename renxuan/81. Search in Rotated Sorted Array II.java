class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) return true;
            if(nums[l] == nums[m] && nums[r] == nums[m]) {
                ++l; --r;
            }
            else if (nums[m] > target) {
                if (nums[l] <= target || nums[m] < nums[l]) r = m - 1;
                else l = m + 1;
            }
            else {
                if (nums[l] > target || nums[m] >= nums[l]) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}
