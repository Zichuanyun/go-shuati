class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        if(nums[end] == target) {
            int[] res = new int[2];
            res[0] = end;
            while(end < nums.length && nums[end] == target ) {
                end++;
            }
            res[1] = end - 1;
            return res;
        } else {
            return new int[]{-1, -1};
        }
    }
}