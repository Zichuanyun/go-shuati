class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = nums.length, l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) return m;
            if(nums[m] > target) {
                if(m < res) res = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        return res;
    }
}