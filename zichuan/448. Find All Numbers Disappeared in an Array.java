class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                list.add(i + 1);
        }
        
        return list;
    }
}