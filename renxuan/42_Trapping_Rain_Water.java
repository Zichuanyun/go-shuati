class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        int leftHighest = 0, rightHighest = 0;
        for(int i = 0; i < n; ++i) {
            leftHighest = Math.max(leftHighest, height[i]);
            left[i] = leftHighest;
        }
        for(int i = n - 1; i >= 0; --i) {
            rightHighest = Math.max(rightHighest, height[i]);
            right[i] = rightHighest;
        }
        int res = 0;
        for(int i = 0; i < n; ++i) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
