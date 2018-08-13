class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        int i = nums.length - 1;
        while(i > 0 && nums[i - 1] >= nums[i]) --i;
        reverse(nums, i);
        if(i > 0){
            int k = i--;
            while(nums[k] <= nums[i]) ++k;
            swap(nums, i, k);
        }
    }
    
    private void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
    
    private void reverse(int[] nums, int start) {
        for (int end = nums.length - 1; start <= end; start++, end--) {
            swap(nums, start, end);
        }
    }
}
