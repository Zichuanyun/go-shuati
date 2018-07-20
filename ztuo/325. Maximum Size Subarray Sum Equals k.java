class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0; int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) max = Math.max(max, i + 1);
            else if(map.containsKey(sum - k)) {
                int index = map.get(sum - k);
                max = Math.max(max, i - index);
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}