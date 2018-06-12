class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i < nums.length; i ++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int search = target-nums[i];
            if(map.containsKey(search) && map.get(search)!=i){
                return new int[] {i, map.get(search)};
            }
        }
        
        throw new IllegalArgumentException();
    }
}
