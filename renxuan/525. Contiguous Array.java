class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == 1) ++count;
            else --count;
            if(map.containsKey(count)) 
                max = Math.max(max, i - map.get(count));
            else map.put(count, i);
        }
        return max;
    }
}
