class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        return nums[quick_select(0, nums.size() - 1, k, nums)];
    }
    int quick_select(int lo, int hi, int k, vector<int> &nums) {
        if(lo == hi) return lo;
        int p = partition(lo, hi, nums);
        int len = hi - p;
        if(len == k - 1) return p;
        else if(len < k - 1) return quick_select(lo, p - 1, k - len - 1, nums);
        else return quick_select(p + 1, hi, k, nums);
    }
    int partition(int lo, int hi, vector<int> &nums) {
        int i = lo;
        for(int j = i; j < hi; j++)
            if(nums[j] <= nums[hi])
                swap(nums[i++], nums[j]);
        swap(nums[i], nums[hi]);
        return i;
    }
};
