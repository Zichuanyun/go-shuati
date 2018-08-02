class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int row = matrix.length, col = matrix[0].length, res = Integer.MIN_VALUE;
        for(int l=0; l<col; ++l) {
            int[] localSum = new int[row];
            for(int r=l; r<col; ++r) {
                for(int i=0; i<row; ++i) {
                    localSum[i] += matrix[i][r]; // this is a one-column array
                }
                
                TreeSet<Integer> accuSet = new TreeSet<>();
                accuSet.add(0); // this guarantee your when curSum reaches k, curMax can be k
                int curSum = 0, curMax = Integer.MIN_VALUE;
                for(int sum : localSum) {
                    curSum += sum;
                    Integer subres = accuSet.ceiling(curSum - k);
                    if(subres != null) curMax = Math.max(curMax, curSum - subres);
                    accuSet.add(curSum);
                }
                res = Math.max(res, curMax);
            }            
        }
        return res;
    }
}
