class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int lo = 0, hi = n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(target <= nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if(lo == n || nums[lo] != target) return {-1, -1};
        int left = lo;
        lo = 0, hi = n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(target >= nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int right = lo;
        return {left, right - 1};
    }
};
