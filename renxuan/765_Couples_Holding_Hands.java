class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] partner = new int[n];
        int[] rev = new int[n];
        for(int i = 0; i < n; ++i) {
            partner[i] = (i % 2 == 0)? i + 1 : i - 1;
            rev[row[i]] = i;
        }
        
        int res = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = partner[rev[partner[row[i]]]]; j != i; j = partner[rev[partner[row[i]]]]) {
                swap(row, i, j);
                swap(rev, row[i], row[j]);
                ++res;
            }
        }
        return res;
    }
    
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
