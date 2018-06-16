public class Solution {
    public int findMin(int[] nums) {
        //corner case
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int low = 0, high = nums.length - 1;
        while(true) {
            int mid = low + (high - low) / 2;
            if(mid == low)
                return nums[low] < nums[high] ? nums[low] : nums[high];
            if(nums[mid] > nums[high])
                low = mid;
            else if(nums[mid] < nums[high])
                high = mid;
            else
                return nums[low];
        }
        return nums[low];
    }
}