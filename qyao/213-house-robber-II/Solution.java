class Solution {
  /*
   * Dynamic programming, the optimal amount for the first k houses is max(S_k-1, S_k-2 + V_k)
   * Using a circular buffer as we only need to remember k-1 and k-2
   * Difference from house robber 1: there can be only two cases, rob the first house or not
   * TODO should use a helper function specifying the start and end
   */
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    // case 1: rob the first house
    int[] circularBuffer = new int[2];
    circularBuffer[0] = nums[0];
    circularBuffer[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length - 1; i++) {
      circularBuffer[i % 2] =
          Math.max(circularBuffer[(i - 1) % 2], circularBuffer[(i - 2) % 2] + nums[i]);
    }
    int robFirstHouse = circularBuffer[(nums.length - 2) % 2];

    // case 2: don't rob the first house
    circularBuffer[0] = 0;
    circularBuffer[1] = nums[1];
    for (int i = 2; i < nums.length; i++) {
      circularBuffer[i % 2] =
          Math.max(circularBuffer[(i - 1) % 2], circularBuffer[(i - 2) % 2] + nums[i]);
    }
    int doNotRobFirstHouse = circularBuffer[(nums.length - 1) % 2];

    return Math.max(robFirstHouse, doNotRobFirstHouse);
  }
}
