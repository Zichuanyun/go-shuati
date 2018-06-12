class Solution {
    public int maxProfit(int[] prices) {
        int buyin1 = Integer.MIN_VALUE;
        int buyin2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int i : prices) {
            
            sell2 = Math.max(sell2, i + buyin2);//start from the backward sequence
            buyin2 = Math.max(sell1 - i, buyin2); 
            
            sell1 = Math.max(sell1, i + buyin1);
            buyin1 = Math.max(-i, buyin1);                      
        }
        return sell2;       
    }
}