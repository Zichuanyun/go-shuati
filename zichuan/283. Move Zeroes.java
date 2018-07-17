class Solution {
    public void moveZeroes(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return;
        int z = 0;
        while (z < nums.length && nums[z] != 0) {
            ++z;
        }
        int non_z = z + 1;
        while (non_z < nums.length && nums[non_z] == 0) {
            ++non_z;
        }
        while (non_z < nums.length) {
            swap(z, non_z, nums);
            while (z < nums.length && nums[z] != 0) {
                ++z;
            }
            ++non_z;
            while (non_z < nums.length && nums[non_z] == 0) {
                ++non_z;
            }
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}