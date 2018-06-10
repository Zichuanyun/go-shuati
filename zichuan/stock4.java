class Solution {
    public int maxProfit(int k, int[] nums) {
        // corner case
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        
        if (k >= nums.length / 2) {
            return fastSolve(nums);
        }
        
        int[] buys = new int[k];
        int[] sells = new int[k];
        
        for (int i = 0; i < k; ++i) {
            buys[i] = Integer.MIN_VALUE;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            int price = nums[i];
            for (int j = 0; j < k; ++j) {
                int ref = - price;
                if (j != 0) {
                    ref = sells[j - 1] - price;
                }
                if (buys[j] < ref) {
                    buys[j] = ref;
                }
                if (sells[j] < buys[j] + price) {
                    sells[j] = buys[j] + price;
                }
            }
        }
        return sells[k - 1];
    }
    
    private int fastSolve(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i] - nums[i - 1];
            }
        }
        return sum;
    }
}