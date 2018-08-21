class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; ++i) {
            for(int j = nums[i]; j > 0 && j <= n && nums[j - 1] != j; j = nums[i]) {
                nums[i] = nums[j - 1];
                nums[j - 1] = j;
            }
        }
        int i = 1;
        for(; i <= n; ++i) {
            if(nums[i - 1] != i) break;
        }
        return i;
    }
}
