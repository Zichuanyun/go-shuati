class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int swap = 1, notswap = 0;
        for(int i = 1; i < n; ++i) {
            int lastNotSwap = notswap, lastSwap = swap;
            notswap = swap = n;
            if(A[i] > A[i - 1] && B[i] > B[i - 1]) {
                notswap = lastNotSwap;
                swap = lastSwap + 1;
            }
            if(B[i] > A[i - 1] && A[i] > B[i - 1]) {
                notswap = Math.min(notswap, lastSwap);
                swap = Math.min(swap, lastNotSwap + 1);
            }
        }
        return Math.min(swap, notswap);
    }
}
