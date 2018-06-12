public class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right], 
                    nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
                System.out.println("-----------------------");
                System.out.println("Left: " + left);
                System.out.println("Right: " + right);
                for (int i = 0; i < dp.length; ++i) {
                    for (int j = 0; j < dp.length; ++j) {
                        System.out.print(dp[i][j] + ",");
                    }
                    System.out.println();
                }
            }
        }
        return dp[0][n - 1];
    }
}