/*
k transactions
*/
class Solution{
    public int maxProfit(int k,int[] prices){
        int n = prices.length;
        if(k*2 > n){
            return maxProfitI(prices);
        }
        
        int[][] array = new int[n][k+1];
        for(int i = 1;i < n;i++){
            for(int j = 1; j< k+1; j++){
                array[i][j] = Math.max(array[i-1][j],prices[i]-prices[0]);
                for(int p = 0; p < i; p++){
                    array[i][j] = Math.max(array[i][j],array[p][j-1]+prices[i]-prices[p]);
                }
            }
        }
        return array[n-1][k];
    }
    
    private int maxProfitI(int[] prices){
        int res = 0;
        for(int i = 1; i<prices.length; i++){
            res += Math.max(prices[i]-prices[i-1],0);
        }
        return res;
    }
}
