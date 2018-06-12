class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else 
            {
                map.remove(nums[i]);
            }
        }
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
