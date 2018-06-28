class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int frontIdx = 0;
        List<int[]> window = new ArrayList<>();
        for(int end = 0; end < n; ++end) {
            int curr = nums[end];
            window.add(new int[]{curr, end});
            if(window.size() > k || end - window.get(0)[1] >= k) window.remove(0);
            int i = 0;
            while(i < window.size() - 1) {
                if(window.get(i)[0] <= curr) {
                    window.remove(i);
                }
                else ++i;
            }                                
            
            if(end >= k - 1) {
                res[end - (k - 1)] = window.get(0)[0];
            }
        }
        return res;
    }
}
