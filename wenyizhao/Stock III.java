class Solution {
    public int maxProfit(int[] prices) {
        int holdOne = Integer.MIN_VALUE, holdTwo = Integer.MIN_VALUE;
        int soldOne = 0, soldTwo = 0;
        for(int price : prices){
            soldTwo = Math.max(soldTwo, holdTwo+price);
            holdTwo = Math.max(holdTwo, soldOne-price);
            soldOne = Math.max(soldOne, holdOne+price);
            holdOne = Math.max(holdOne, 0-price);
        }
        return soldTwo;
    }
}

