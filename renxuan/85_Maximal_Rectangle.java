class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[] height = new int[n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == '0')
                    height[j] = 0;
                else ++height[j];
            }
            int[] left = new int[n], right = new int[n];
            left[0] = -1;
            for(int j = 0; j < n; ++j) {
                int l = j - 1;
                while(l >= 0 && height[l] >= height[j]) {
                    l = left[l];
                }
                left[j] = l;
            }
            right[n - 1] = n;
            for(int j = n - 1; j >= 0; --j) {
                int r = j + 1;
                while(r < n && height[r] >= height[j]) {
                    r = right[r];
                }
                right[j] = r;
            }
            for(int j = 0; j < n; ++j) {
                res = Math.max(res, height[j] * (right[j] - left[j] - 1));
            }
        }
        return res;
    }
}