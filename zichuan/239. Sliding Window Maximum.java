class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[] {};
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 从左边剔除超出边界的
            while (deque.size() > 0 && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 从右边剔除不如我大的
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}