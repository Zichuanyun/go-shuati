class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0, j = 0, n = nums.size();
        for(int k = 0; k <= n; k++) {
            if(k == n || k > 0 && nums[k] != nums[k-1]) {
                i = j;
            }
            if(k < n && j - i < 2) {
                nums[j++] = nums[k];
            }
        }
        return i;
    }
};
