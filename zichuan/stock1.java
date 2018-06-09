class Solution {
    public int[] twoSum(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int offset = target - nums[i];
            if (map.containsKey(offset)) {
                res[0] = i;
                res[1] = map.get(offset);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}