class NumArray {
    
    int[] nums;
    int[] BIT;
    int n;
    
    public NumArray(int[] i_nums) {
        //corner case
        if(i_nums == null || i_nums.length == 0) return;
        nums = i_nums;
        n = nums.length;
        BIT = new int[n + 1];
        
        //init
        for(int i = 0; i < nums.length; i++) {
            init(i + 1, nums[i]);
        }
    }
    
    void init(int idx, int val) {
        while(idx > 0) {
            BIT[idx] += val;
            idx -= (idx & -idx);
            //System.out.println("init");
        }
    }
    
    public void update(int idx, int val) {
        int offset = val - nums[idx];
        nums[idx] = val;
        init(idx + 1, offset); //TODO
    }
    
    int getSum(int i) {
        int sum = 0;
        while(i <= n) {
            sum += BIT[i];
            i += (i & -i);
        }
        return sum;
    }
    
    public int sumRange(int l, int r) {
        return getSum(l + 1) - getSum(r + 2);
    }
}