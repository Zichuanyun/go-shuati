class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int i = start - 1, pivot = nums[end];
        for(int j = start; j <= end; ++j) {
            if(nums[j] >= pivot) {
                int tmp = nums[++i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if(i + 1 == k) return nums[i];
        else if(i + 1 < k) {
            return quickSelect(nums, i + 1, end, k);
        }
        return quickSelect(nums, start, i - 1, k);
    }
}
