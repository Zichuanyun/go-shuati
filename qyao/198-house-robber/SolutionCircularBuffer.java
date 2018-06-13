@SuppressWarnings({"unused", "UnnecessaryReturnStatement"})
class Solution {
  /*
   * Dynamic programming, the optimal amount for the first k houses is max(S_k-1, S_k-2 + V_k)
   * Using a circular buffer as we only need to remember k-1 and k-2
   */
  public int rob(int[] nums) {
    // fuck you corner cases
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] circularBuffer = new int[2];
    circularBuffer[0] = nums[0];
    circularBuffer[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      circularBuffer[i % 2] =
          Math.max(circularBuffer[(i - 1) % 2], circularBuffer[(i - 2) % 2] + nums[i]);
    }
    return circularBuffer[(nums.length - 1) % 2];
  }
}
