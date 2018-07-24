class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            while(i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
            int k = nums.length - 1;
            int j = i + 1;
            int sum = -nums[i];
            while(j < k) {
                if(nums[k] + nums[j] == sum) {
                    result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(k > j && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if(nums[k] + nums[j] > sum) {
                    k--;
                } else{
                    j++;
                }
            }
        }
        return result;
    }
}