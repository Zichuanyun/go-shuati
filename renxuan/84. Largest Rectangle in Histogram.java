class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        for(int i = 0; i < n; ++i) {
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }
        for(int i = n - 1; i >= 0; --i) {
            int p = i + 1;
            while(p < n && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
        }
        int res = 0;
        for(int i = 0; i < n; ++i) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
