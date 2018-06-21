/*
Input: [1,2,3,1]
Output: 4

like:188 stock
Dp
    dp[i] = max(num[i] + dp[i - 2], dp[i - 1])
Time:o(n)
Space:O(1)
*/

class Solution {
    public int rob(int[] nums) {
    int[] pre = new int[2];
    
    for(int num : nums){
       int tmp = pre[1];
       pre[1] = Math.max(pre[1],pre[0]+num);
       pre[0] = tmp;
    }
    return pre[1];
    }
}
