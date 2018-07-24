class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        int curr = nums[0];
        int cnt = 1;
        int leftptr = 1;
        for (int i = 1; i < nums.size(); i ++) {
            if (nums[i] == curr) {
                if (cnt >= 2) {
                    continue;
                } else {
                    cnt ++;
                    nums[leftptr++] = nums[i];
                }
            } else {
                curr = nums[i];
                cnt = 1;
                nums[leftptr++] = nums[i];
            }
        }
        nums.resize(leftptr);
        return nums.size();
    }
};
