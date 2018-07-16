class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0, i = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
            ++i;
        }
        while(index < nums.length) {
            nums[index++] = 0;
        }
    }
}
