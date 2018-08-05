class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        
        int[] tails = new int[envelopes.length + 1];
        Arrays.fill(tails, Integer.MAX_VALUE);
        tails[0] = Integer.MIN_VALUE;
        int max = 0;
        for(int[] env : envelopes) {
            int pos = insertPos(tails, env[1]);
            max = Math.max(max, pos);
            tails[pos] = env[1];
        }
        
        return max;
    }
    
    private int insertPos(int[] A, int num) {
        int l = 0, r = A.length;
        while(l < r) {
            int m = l + (r - l)/2;
            if(A[m] < num) {
                l = m + 1;
            }
            else r = m;
        }
        return l;
    }
}
