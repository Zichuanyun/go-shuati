class NumArray {
    vector<int> a, c;
    int n;
public:
    NumArray(vector<int> nums) {
        n = nums.size();
        a = vector<int>(n);
        c = vector<int>(n + 1);
        for(int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - a[i];
        a[i] = val;
        i++;
        while(i <= n) {
            c[i] += diff;
            i += i & (-i);
        }
    }

    int query(int i) {
        i++;
        int sum = 0;
        while(i) {
            sum += c[i];
            i -= i & (-i);
        }
        return sum;
    }
    
    int sumRange(int i, int j) {
        return query(j) - query(i-1);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
