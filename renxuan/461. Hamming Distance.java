class Solution {
    public int hammingDistance(int x, int y) {
        return countOne(x ^ y);
    }
    
    private int countOne(int n) {
        int res = 0;
        while(n != 0) {
            ++res;
            n = n & (n - 1);
        }
        return res;
    }
}
