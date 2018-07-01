class Solution {
public:
    int trap(vector<int>& height) {
        int i = 0, j = height.size() - 1;
        int ans = 0;
        int lmax = 0, rmax = 0;
        while(i < j) {
            if(height[i] < height[j]) {
                if(height[i] < lmax) {
                    ans += lmax - height[i];
                } else {
                    lmax = height[i];
                }
                i++;
            } else {
                if(height[j] < rmax) {
                    ans += rmax - height[j];
                } else {
                    rmax = height[j];
                }
                j--;
            }
        }
        return ans;
    }
};
