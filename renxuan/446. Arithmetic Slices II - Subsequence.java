class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        Map<Integer, Integer>[] map = new Map[n];
        int res = 0;
        for(int i = 0; i < n; ++i) {
            map[i] = new HashMap<>();
            for(int j = 0; j < i; ++j) {
                long diff = (long)A[i] - A[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE)
                    continue;
                int d = (int)diff;
                int count = map[j].getOrDefault(d, 0);
                res += count;
                map[i].put(d, map[i].getOrDefault(d, 0) + count + 1);
            }
        }
        return res;
    }
}
