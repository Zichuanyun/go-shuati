class Solution {
    public int maxProfit(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int tail = 0, head = 0, globalMax = 0;        
        for (int i = 0; i < nums.length; ++i) {
            head = i;
            int tailVal = nums[tail];
            int headVal = nums[head];
            if (headVal > tailVal) {
                globalMax = Math.max(globalMax, headVal - tailVal);
            } else {
                tail = head;
            }
        }
        
        return globalMax;
        
    }
}