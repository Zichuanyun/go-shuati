class Solution {
    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[high];
    }
}