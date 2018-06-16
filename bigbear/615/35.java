class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        // if(target > nums[nums.length - 1]) return nums.length;
        
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}