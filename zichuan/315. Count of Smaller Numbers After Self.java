class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        int n = nums.length;
        
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        for (int num : nums) {
            minVal = Math.min(minVal, num);
        }
        
        int[] nums2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums2[i] = nums[i] - minVal + 1;
            maxVal = Math.max(maxVal, nums2[i]);
        }
        
        int[] BIT = new int[maxVal];
        
        Integer[] res = new Integer[nums.length];
        
        for (int i = n - 1; i >= 0; --i) {
            res[i] = search(BIT, nums2[i] - 1);
            insert(BIT, nums2[i]);
        }
        
        return Arrays.asList(res);
    }
    
    private int search(int[] BIT, int idx) {
        int res = 0;
        while (idx > 0) {
            res += BIT[idx];
            idx -= idx & (-idx);
        }
        return res;
    }
    
    private void insert(int[] BIT, int idx) {
        while (idx < BIT.length) {
            ++BIT[idx];
            idx += idx & (-idx);
        }
    }
}