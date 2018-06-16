public class Solution {
    public int search(int[] nums, int target) {
        //corner case
        int len = nums.length;
        if(len == 0) return -1;
        int low = 0, high = nums.length - 1;
        int rot = 0;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[low])
                high = mid;
            else if(nums[mid] > nums[high])
                low = mid + 1;
            else
                break;
        }
        rot = low;
        low = 0;
        high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int r_low = (low + rot) % len;
            int r_high = (high + rot) % len;
            int r_mid = (mid + rot) % len;
            if(nums[r_mid] < target)
                low = mid + 1;
            else if(nums[r_mid] > target)
                high = mid - 1;
            else
                return r_mid;
        }
        return -1;

    }
}