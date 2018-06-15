class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) return m;
            if(nums[m] > target) {
                if(target >= nums[l] || nums[m] < nums[l]) r = m - 1;
                else l = m + 1;
            }
            else {
                if(nums[m] >= nums[l] || target < nums[l]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}