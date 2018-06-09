class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int not_rob = 0;
        for(int n : nums) {
            int temp = rob;
            rob = not_rob + n;
            not_rob = Math.max(temp, not_rob);
        }
        return Math.max(rob, not_rob);
    }
}