class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        int lo = 0, hi = n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(nums[mid] >= nums[0]) {
                if(target >= nums[0] && target < nums[mid])
                    hi = mid;
                else
                    lo = mid + 1;
            } else {
                if(target <= nums[n-1] && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid;
            }
        }
        return (lo == n || nums[lo] != target) ? -1 : lo;
    }
};
