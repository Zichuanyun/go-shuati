class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robCircle(nums, 0, nums.length-1), robCircle(nums, 1, nums.length-1));
    }
    private int robCircle(int[] nums, int start, int length){
        if(length == 1) return nums[start];
        if(length == 2) return Math.max(nums[start], nums[start+1]);
        int[] result = new int[length];
        result[0] = nums[start];
        result[1] = Math.max(nums[start], nums[start+1]);
        //NOTE, do not mix the indicator for original and sub array
        for(int i = start + 2, j = 2; i < start+length; i++, j++){
            System.out.println(i);
            result[j] = Math.max(result[j-1], result[j-2]+nums[i]);
        }
        System.out.println(result[length-1]+ "  !");
        return result[length-1];
    }
}
