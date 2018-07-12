class NumArray {
    vector<int> sum;
public:
    NumArray(vector<int> nums) {
        sum.swap(nums);
        for(int i = 1; i < sum.size(); i++) sum[i] += sum[i-1];
    }
    
    int sumRange(int i, int j) {
        return sum[j] - (i > 0 ? sum[i-1] : 0);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
