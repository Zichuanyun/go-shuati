class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length, count = M.length;
        int[] union = new int[n];
        Arrays.fill(union, -1);
        
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if(M[i][j] == 1) {
                    int f1 = i, f2 = j;
                    while(union[f1] != -1) f1 = union[f1];
                    while(union[f2] != -1) f2 = union[f2];
                    if(f1 == f2) continue;
                    union[f2] = f1;
                    --count;
                }
            }
        }
        return count;
    }
}