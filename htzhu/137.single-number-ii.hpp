class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // base 3 counter
        // Result: ab == 01, so return b
        int a, b;
        a = b = 0;
        for(int c: nums) {
            int ta = a;
            a = a & ~c | b & c;
            b = b & ~c | ~ta & ~b & c;
        }
        return b;
    }
};
