class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> temp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!temp.containsKey(target - nums[i])) {
                temp.put(nums[i], i);
            }
            else {
                res[0] = i; res[1] = temp.get(target - nums[i]);
                break;
            }
        }
        return res;
    }
}