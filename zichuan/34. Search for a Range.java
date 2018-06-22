class Solution {
    public int[] searchRange(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int left = 0, right = nums.length - 1;
        int[] res = new int[] {-1, -1};
        
        // find leftBound
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (left >= nums.length || nums[left] != target) {
            return res;
        }
        
        res[0] = left;
        
        left = 0;
        right = nums.length - 1;
        
        // find rigthBound
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                System.out.println(left);
            } else {
                right = mid - 1;
            }
        }
        
        res[1] = left - 1;
        
        return res;
    }
}