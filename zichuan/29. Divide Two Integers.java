class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        int sign = 1;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long res = ldivide(a, b) * sign;
        return (int)res;
        
    }
    
    public int ldivide(long a, long b) {
        if(a < b) return 0;
        int count = 1;
        long sum = b;
        while(a > sum + sum) {
           sum += sum;
           count += count;
        }
        return count + ldivide(a - sum, b);
    }
}
