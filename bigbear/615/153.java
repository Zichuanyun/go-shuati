class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        
        while(lo < hi){
            int mid = (hi - lo)/2 + lo;
            
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        return nums[hi];
    }
}