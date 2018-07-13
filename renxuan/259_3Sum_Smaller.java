public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 2 && nums[i] * 3 < target; ++i) {
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    ++j;
                }
                else --k;
            }
        }
        return res;
    }
}
