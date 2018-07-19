public class Solution {
    Maximum Size Subarray Sum Equals kpublic int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0, sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                int prev = map.get(sum - k);
                res = Math.max(res, i - prev);
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return res;
    }
}
