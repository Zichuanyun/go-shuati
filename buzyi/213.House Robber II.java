/*
if All houses at this place are arranged in a circle.
enum rob at day 0:
    @base case: size ==1!!
*/

class Solution {
 public int rob(int[] nums) {
    if(nums.length == 1){
        return nums[0];
    }
    //rob at day 0
   int robday0 = robProfit(nums,0,nums.length-1);
    //not rob at day 0
   int notrobday0 = robProfit(nums,1,nums.length);
    return Math.max(robday0,notrobday0);
    }
    
    private int robProfit(int[] nums,int start,int end){
       int[] pre = new int[2];
       for(int i =start; i<end; i++){
        int tmp = pre[1];
        pre[1] = Math.max(pre[1],pre[0]+nums[i]);
        pre[0] = tmp;
    	}
        return pre[1];
    }
}
