class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[0] = 1;
        for(int i = 1; i < n; ++i) {
            product[i] = nums[i - 1] * product[i - 1];
        }
        int right = 1;
        for(int i = n - 2; i >= 0; --i) {
            right *= nums[i + 1];
            product[i] *= right;
        }
        return product;
    }
}
