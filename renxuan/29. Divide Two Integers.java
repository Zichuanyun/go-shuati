class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long)dividend), div = Math.abs((long)divisor), res = 0, cur = 1;
        if(dvd < div) return 0;
        while(dvd >= div * (cur << 1)) {
            cur <<= 1;
        }
        while(cur > 0) {
            if(dvd >= div * cur) {
                res += cur;
                dvd -= div * cur;
            }
            cur >>= 1;
        }
        if(neg) res = -res;
        if(res < Integer.MIN_VALUE || res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}
