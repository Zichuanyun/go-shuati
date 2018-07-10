public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while(l < r) {
            maxArea = Math.max(maxArea, Math.min(height[r], height[l]) * (r - l));
            if(height[l] > height[r])
                r--;
            else
                l++;
        }
        return maxArea;
    }
}