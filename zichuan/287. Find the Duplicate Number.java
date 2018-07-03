class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) break;
        } while (true);
        
        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
            if (slow == fast) break;
        } while (true);
        return fast;
    }
}