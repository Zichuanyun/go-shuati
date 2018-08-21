class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, maxToPrev = 1, minToPrev = 1;
        for(int num : nums) {
            if(num >= 0) {
                maxToPrev = Math.max(num, num * maxToPrev);
                minToPrev = Math.min(num, num * minToPrev);
            }
            else {
                int tmp = Math.max(num, num * minToPrev);
                minToPrev = Math.min(num, num * maxToPrev);
                maxToPrev = tmp;
            }
            max = Math.max(max, maxToPrev);
        }
        return max;
    }
}
