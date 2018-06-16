class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = helper(nums, target);
        if(nums.length == 0 ||start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        return new int[]{start, helper(nums, target + 1) - 1};
    }
    
    private int helper(int[] nums, int target){
        if(nums.length == 0) return -1;
        int lo = 0, hi = nums.length;
        while(lo < hi){
            int mid = (hi - lo)/2 + lo;
            if(nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}