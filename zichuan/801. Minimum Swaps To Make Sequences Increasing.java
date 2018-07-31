class Solution {
    public int minSwap(int[] A, int[] B) {
        // corner case
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int len = A.length;
        int[] swap = new int[len];
        int[] keep = new int[len];
        Arrays.fill(swap, len);
        Arrays.fill(keep, len);
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                keep[i] = keep[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
                keep[i] = Math.min(swap[i - 1], keep[i]);
            }
            
        }
        return Math.min(keep[len - 1], swap[len - 1]);
    }
}