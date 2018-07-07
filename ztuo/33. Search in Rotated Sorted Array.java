class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        
        int start = 0;
        int len = nums.length;
        int end = len - 1;
        // find the smallest value
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int pad = start;
        start = 0; end = len - 1;
        //the usual binary search
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int realmid = (mid + pad) % len;
            if(nums[realmid] < target) {
                start = mid + 1;
            } else if (nums[realmid] > target) {
                end = mid - 1;
            } else {
                return realmid;
            }
        }
        return -1;        
    }
}