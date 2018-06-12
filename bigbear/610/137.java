class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for(int i: nums){
            one = (one ^ i) & ~two;
            two = (two ^ i) & ~one;
        }
        return one;
        
    }
}
// '''
// 这题真够难理解的，应该是三重状态机。
// one two共同维持三个状态分别是，10，01，00
// 
// 
// '''