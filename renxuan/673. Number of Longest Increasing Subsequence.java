class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length, longest = 0, ans = 0;
        int[] length = new int[n], counts = new int[n];
        Arrays.fill(counts, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        counts[i] = counts[j];
                    } else if (length[j] + 1 == length[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            longest = Math.max(longest, length[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (length[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
