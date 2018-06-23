class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        int n = nums.length;
        int[][] MyResult = new int[n][n];
        
        for(int[] row : MyResult){
        Arrays.fill(row,-1);
        }
        
        dfs(0,n-1,MyResult,nums);
        return MyResult[0][n-1];
    }
    
    private int dfs(int i,int j, int[][] MyResult,int[] nums){
        if(j < i){
            return 0;
        }
        
        if(MyResult[i][j] != -1){
            return MyResult[i][j];
        }else{
           int left =(i> 0) ? nums[i-1] : 1;
           int right=(j < nums.length-1) ? nums[j+1] : 1;
            for(int p = i; p <= j ; p++){
               MyResult[i][j] = Math.max(MyResult[i][j],
                                         dfs(i,p-1,MyResult,nums) + dfs(p+1,j,MyResult,nums)
                                            + left * nums[p] * right);
                }
            }
         return MyResult[i][j];
    }
}
