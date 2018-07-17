class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int nonZeroPoint = 0;
        for (int i = 0; i < nums.size(); i ++) {
            if (nums[i] != 0) 
                nums[nonZeroPoint++] = nums[i];
        }
        for (int i = nonZeroPoint; i < nums.size(); i ++) {
            nums[i] = 0;
        }
    }
};
