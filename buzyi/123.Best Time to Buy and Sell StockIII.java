/*
two transactions:
Solution 1
*/

class Solution {
    public int maxProfit(int[] prices) {
     if(prices.length ==0){
            return 0;
        }
         int n = prices.length;
    int[][] arr = new int[n][3];
    
    for(int j = 1; j <= 2; j++){
           int localmax =0;
        for(int i = 1;i < n;i++){
            arr[i][j]=Math.max(prices[i]-prices[0],arr[i-1][j]);
            if(i>1){   
            localmax = localmax+prices[i]-prices[i-1];
            localmax = Math.max(localmax,arr[i-2][j-1]+prices[i]-prices[i-1]);
            }
            arr[i][j]=Math.max(arr[i][j],localmax);
        }
    }
    return arr[n-1][2];
    }
}

/*
Solution 2
*/

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for(int i = 0;i < prices.length;i++) {
            if(i > 2) {
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            if(i > 1) {
                buy2 = Math.max(buy2, sell1 - prices[i]);
            }
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }
        return Math.max(sell1, sell2);
    }
}
