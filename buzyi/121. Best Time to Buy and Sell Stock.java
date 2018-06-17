/*
Price [7,1,5,3,6,4]
gain    [-6,4,-2,3,-2]
F[i] == Max(F[i-1] + gain[i]), gain[i]) //ending with g[i]
*/
public int maxProfit(int[] nums){
    if(nums.length == 0){
        return 0;
    }
    
    int res = 0;
    int localP=0;
    for(int i = 1; i< nums.length; i++){
        localP = Math.max(localP+(nums[i]-nums[i-1]),nums[i]-nums[i-1]);
        res = Math.max(res,localP);
    }
    return res;
}
