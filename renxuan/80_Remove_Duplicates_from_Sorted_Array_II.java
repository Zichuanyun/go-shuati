class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0, end = 0, dup = 0;
        while(end < nums.length) {
            if(dup == 1 && nums[end] == nums[end - 1]) ++end;
            else if(dup == 0 && end > 0 && nums[end] == nums[end - 1]) {
                ++dup;
                nums[index++] = nums[end++];
            }
            else {
                dup = 0;
                nums[index++] = nums[end++];
            }
        }
        return index;
    }
}
