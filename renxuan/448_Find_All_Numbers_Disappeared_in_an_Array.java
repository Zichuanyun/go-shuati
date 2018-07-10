class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            for(int j = nums[i]; nums[j - 1] != j; j = nums[i]) {
                nums[i] = nums[j - 1];
                nums[j - 1] = j;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }
}
