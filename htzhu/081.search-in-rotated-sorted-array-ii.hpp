class Solution {
public:
    bool search(vector<int>& nums, int target) {
        if(nums.empty()) return false;
        int lo = 0, hi = nums.size() - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return true;
            if(nums[lo] == nums[mid]) lo++;
            else if(nums[mid] > nums[lo]) {
                if(target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if(target <= nums[hi] && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return false;
    }
};
