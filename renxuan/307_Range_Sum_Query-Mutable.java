class NumArray {
    int[] BIT, array;

    public NumArray(int[] nums) {
        array = new int[nums.length];
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - array[i];
        array[i] = val;
        for(int j = i + 1; j <= array.length; j += lowBit(j)) {
            BIT[j] += diff;
        }
    }
    
    public int sumRange(int i, int j) {
        return prefixSum(j) - prefixSum(i - 1);
    }
    
    private int prefixSum(int i) {
        ++i;
        int sum = 0;
        while(i > 0) {
            sum += BIT[i];
            i -= lowBit(i);
        }
        return sum;
    }
    
    private int lowBit(int i) {
        return i & (-i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
 