class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        if (nums.size() < 3)
            return false;
        int smallestIndex = 0;
        int midNumIndex = -1;
        for (int i = 1; i < nums.size(); i ++) {
            // Bigger the second large number, found the largest one.
            if (midNumIndex != -1 && nums[i] > nums[midNumIndex])
                return true;
            // Bigger number found after the smallest, update the index.
            if (nums[i] > nums[smallestIndex] && (midNumIndex == -1 || nums[i] < nums[midNumIndex]))
                midNumIndex = i;
            // No matter to change smallest even it's behind the original second large number.
            // It's alreay a smaller number before the second large number.
            if (nums[i] < nums[smallestIndex])
                smallestIndex = i;
        }
        return false;
    }
};
