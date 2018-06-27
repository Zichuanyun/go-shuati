class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] right = new int[n], res = new int[n];
        for(int i = n - 1; i >= 0; --i) {
            int p = i + 1;
            while(p != n && temperatures[i] >= temperatures[p]) {
                if (res[p] > 0) p = p + res[p];
                else p = n;
            }
            res[i] = (p == n)? 0 : p - i;
        }
        return res;
    }
}
