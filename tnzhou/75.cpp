class Solution {
public:
    void sortColors(vector<int>& nums) {
        int leftNext = 0;
        int rightNext = nums.size() - 1;
        while (leftNext < nums.size() && nums[leftNext] == 0)
            leftNext++;
        while (rightNext >= 0 && nums[rightNext] == 2)
            rightNext--;
        for (int i = leftNext; i <= rightNext;) {
            i = max(leftNext, i);
            if (nums[i] == 0) {
                swap(nums[i], nums[leftNext]);
                i++;
                leftNext++;
            } else if (nums[i] == 2) {
                swap(nums[i], nums[rightNext]);
                rightNext--;
            } else {
                i++;
            }
        }
    }
};
