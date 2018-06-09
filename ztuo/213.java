class Solution {
    public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
}
    private int rob(int[] nums, int low, int high){
        int rob=0; int not_rob=0;
        for(int i=low; i<=high;i++){
            int temp=not_rob;
            not_rob=Math.max(temp,rob);
            rob=temp+nums[i];
        }
        return Math.max(rob, not_rob);
    }
}