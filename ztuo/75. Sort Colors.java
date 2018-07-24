class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, i, l);
                i++;
                l++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }       
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}