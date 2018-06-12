class Solution {
    public int[] singleNumber(int[] nums) {
        int singles = 0;
        for(int n : nums) {
            singles = singles ^ n;
        }
        singles &= -singles;
        int first = 0;
        int sec = 0;
        for(int n:nums) {
            if((n & singles) == 0){
                first = first ^ n;
            } else {
                sec = sec ^ n;
            }
        }
        return new int[]{first, sec};
    }
}